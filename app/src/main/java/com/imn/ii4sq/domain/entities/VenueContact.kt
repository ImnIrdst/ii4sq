package com.imn.ii4sq.domain.entities

import com.google.gson.annotations.SerializedName

data class VenueContact(
    @SerializedName("formattedPhone") val formattedPhone: String?,
)
