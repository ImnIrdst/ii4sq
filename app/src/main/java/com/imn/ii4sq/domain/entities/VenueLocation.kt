package com.imn.ii4sq.domain.entities

import com.google.gson.annotations.SerializedName

data class VenueLocation(
    @SerializedName("latitude") val latitude: Double,
    @SerializedName("longitude") val longitude: Double,
)
