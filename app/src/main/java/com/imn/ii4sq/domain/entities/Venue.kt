package com.imn.ii4sq.domain.entities

import com.google.gson.annotations.SerializedName

data class Venue(
    @SerializedName("id") val id: String,
    @SerializedName("name") val name: String,
    @SerializedName("location") val location: VenueLocation,
)