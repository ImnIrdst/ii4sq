package com.imn.ii4sq.utils

import android.location.Location
import com.google.android.gms.maps.GoogleMap
import com.imn.ii4sq.domain.entities.LocationEntity

fun GoogleMap.getMapVisibleRadius(): Double {
    val visibleRegion = projection.visibleRegion
    val diagonalDistance = FloatArray(1)
    val farLeft = visibleRegion.farLeft
    val nearRight = visibleRegion.nearRight
    Location.distanceBetween(
        farLeft.latitude,
        farLeft.longitude,
        nearRight.latitude,
        nearRight.longitude,
        diagonalDistance
    )
    return (diagonalDistance[0] / 2).toDouble()
}

fun LocationEntity.distanceTo(other: LocationEntity): Double {
    val diagonalDistance = FloatArray(1)
    Location.distanceBetween(
        this.latitude,
        this.longitude,
        other.latitude,
        other.longitude,
        diagonalDistance
    )
    return diagonalDistance[0].toDouble()
}

fun GoogleMap.getTargetLocation(): LocationEntity {
    val visibleRegion = projection.visibleRegion
    val diagonalDistance = FloatArray(1)
    val farLeft = visibleRegion.farLeft
    val nearRight = visibleRegion.nearRight
    Location.distanceBetween(
        farLeft.latitude,
        farLeft.longitude,
        nearRight.latitude,
        nearRight.longitude,
        diagonalDistance
    )
    return LocationEntity(
        (farLeft.latitude + nearRight.latitude) / 2,
        (farLeft.longitude + nearRight.longitude) / 2,
    )
}