package com.imn.ii4sq.domain.entities

import com.google.gson.annotations.SerializedName

data class VenueDetails(
    @SerializedName("id") val id: String,
    @SerializedName("name") val name: String,
    @SerializedName("location") val location: VenueLocation,
    @SerializedName("contact") val contact: VenueContact,
    @SerializedName("description") val description: String?,
) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as VenueDetails

        if (id != other.id) return false

        return true
    }

    override fun hashCode() = id.hashCode()
}