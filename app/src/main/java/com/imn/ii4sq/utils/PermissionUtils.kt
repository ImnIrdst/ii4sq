package com.imn.ii4sq.utils

import android.Manifest
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment

val LOCATION_PERMISSIONS = arrayOf(
    Manifest.permission.ACCESS_FINE_LOCATION,
    Manifest.permission.ACCESS_COARSE_LOCATION
)

fun Fragment.shouldShowRequestPermissionRationaleCompat(permissions: Array<String>): Boolean {
    for (permission in permissions) {
        if (ActivityCompat.shouldShowRequestPermissionRationale(requireActivity(), permission)) {
            return true
        }
    }
    return false
}