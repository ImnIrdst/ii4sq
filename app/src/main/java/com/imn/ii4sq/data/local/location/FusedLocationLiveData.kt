package com.imn.ii4sq.data.local.location

import android.annotation.SuppressLint
import android.content.Context
import android.location.Location
import android.os.Looper
import androidx.lifecycle.LiveData
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationResult
import com.google.android.gms.location.LocationServices
import com.imn.ii4sq.domain.entities.IIError
import com.imn.ii4sq.domain.entities.LocationEntity
import com.imn.ii4sq.domain.entities.State
import com.imn.ii4sq.domain.entities.failureState
import com.imn.ii4sq.domain.entities.loadingState
import com.imn.ii4sq.domain.entities.successState


class FusedLocationLiveData(context: Context) : LiveData<State<LocationEntity>>() {

    private var fusedLocationClient = LocationServices.getFusedLocationProviderClient(context)

    override fun onInactive() {
        super.onInactive()
        fusedLocationClient.removeLocationUpdates(locationCallback)
    }

    @SuppressLint("MissingPermission")
    override fun onActive() {
        super.onActive()
        value = loadingState()
        fusedLocationClient.lastLocation
            .addOnSuccessListener { location: Location? ->
                setLocationData(location)
            }
            .addOnFailureListener {
                sendError(it)
            }
        startLocationUpdates()
    }

    @SuppressLint("MissingPermission")
    private fun startLocationUpdates() {
        fusedLocationClient.requestLocationUpdates(
            locationRequest,
            locationCallback,
            Looper.getMainLooper()
        )
    }

    private val locationCallback = object : LocationCallback() {
        override fun onLocationResult(locationResult: LocationResult?) {
            if (locationResult == null) {
                sendError(IIError.LocationIsNull)
                return
            }
            for (location in locationResult.locations) {
                setLocationData(location)
            }
        }
    }

    private fun setLocationData(location: Location?) {
        if (location == null) {
            sendError(IIError.LocationIsNull)
        } else {
            val state = successState(
                LocationEntity(
                    longitude = location.longitude,
                    latitude = location.latitude
                )
            )
            if (state != value) {
                value = state
            }
        }
    }

    private fun sendError(cause: Throwable) {
        value = failureState(cause)
    }

    companion object {
        val locationRequest: LocationRequest = LocationRequest.create().apply {
            interval = 3600_000
            fastestInterval = 3600_000
            priority = LocationRequest.PRIORITY_HIGH_ACCURACY
        }
    }
}
