package com.imn.ii4sq.domain.entities

import android.content.Context
import com.imn.ii4sq.R
import com.imn.ii4sq.utils.DebugUtils
import android.util.Log
import com.imn.ii4sq.utils.isConnectedToNet
import retrofit2.HttpException
import java.net.UnknownHostException

sealed class State<out R> {
    object Loading : State<Nothing>()
    data class Success<out V>(val value: V) : State<V>()
    data class Failure(val error: IIError) : State<Nothing>()
}

fun <V> loadingState(): State<V> = State.Loading
fun <V> successState(value: V): State<V> = State.Success(value)
fun <V> failureState(error: IIError): State<V> = State.Failure(error)
fun <V> failureState(error: Throwable): State<V> = State.Failure(error.asIIError())

sealed class IIError(cause: Throwable) : Throwable(cause) {
    class Network(cause: Throwable) : IIError(cause)
    class Unknown(cause: Throwable) : IIError(cause) {
        init {
            if (DebugUtils.isDebug) {
                // also send this to crash reporting service
                Log.e("IIError", "unknown error", cause)
                throw cause // this cause crashes in debug mode to resolve them in development phase and don't use general purpose error handling
            }
        }
    }

    override fun equals(other: Any?): Boolean = other is IIError && cause == other.cause
    override fun hashCode(): Int = cause.hashCode()
    override fun toString(): String = "IIError($cause)"
}


fun Throwable.asIIError(): IIError =
    when (this) {
        is IIError -> this
        is UnknownHostException -> IIError.Network(this)
        is HttpException -> IIError.Network(this)
        else -> IIError.Unknown(this)
    }.also {
        if (DebugUtils.isDebug) {
            Log.e("IIError", "Throwable.asIIError $it", it)
        }
    }

fun IIError.humanReadable(context: Context) =
    context.getString(
        when (this) {
            is IIError.Unknown -> R.string.unknown_error
            is IIError.Network -> {
                when {
                    this.toString().contains("HTTP 429") -> {
                        R.string.rate_limit_happend
                    }
                    context.isConnectedToNet() -> {
                        R.string.network_error
                    }
                    else -> {
                        R.string.check_your_internet_connection
                    }
                }
            }
        }
    )