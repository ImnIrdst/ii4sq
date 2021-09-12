package com.imn.ii4sq.utils

import android.annotation.SuppressLint
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build

@SuppressLint("MissingPermission")
fun Context.isConnectedToNet(): Boolean {
    val connectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        connectivityManager.isConnectedToNetAfterM()
    } else {
        connectivityManager.isConnectedToNetAfterBeforeM()
    }
}

@SuppressLint("MissingPermission")
private fun ConnectivityManager.isConnectedToNetAfterBeforeM(): Boolean {
    @Suppress("DEPRECATION")
    return activeNetworkInfo?.run {
        when (type) {
            ConnectivityManager.TYPE_WIFI -> true
            ConnectivityManager.TYPE_MOBILE -> true
            ConnectivityManager.TYPE_ETHERNET -> true
            else -> false
        }
    } ?: false
}

@SuppressLint("MissingPermission", "NewApi")
private fun ConnectivityManager.isConnectedToNetAfterM(): Boolean {
    val networkCapabilities = getNetworkCapabilities(activeNetwork)
        ?: return false

    return when {
        networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
        networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
        networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
        else -> false
    }
}
