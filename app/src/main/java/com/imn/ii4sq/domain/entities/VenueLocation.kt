package com.imn.ii4sq.domain.entities

import com.google.android.gms.maps.model.LatLng
import com.google.gson.annotations.SerializedName

data class VenueLocation(
    @SerializedName("lat") val latitude: Double,
    @SerializedName("lng") val longitude: Double,
) {
    fun toGoogleMapLatLng() = LatLng(latitude, longitude)

    fun toLocationEntity() = LocationEntity(latitude, longitude)
}
