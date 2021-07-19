package com.imn.ii4sq.domain.entities

import android.os.Parcelable
import com.google.android.gms.maps.model.LatLng
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class VenueLocation(
    @SerializedName("lat") val latitude: Double,
    @SerializedName("lng") val longitude: Double,
    @SerializedName("address") val address: String,
): Parcelable {
    fun toGoogleMapLatLng() = LatLng(latitude, longitude)

    fun toLocationEntity() = LocationEntity(latitude, longitude)
}
