package com.imn.ii4sq.domain.entities

import com.google.gson.annotations.SerializedName

data class Venue(
    @SerializedName("id") val id: String,
    @SerializedName("name") val name: String,
    @SerializedName("location") val location: VenueLocation,
) {
    override fun toString(): String {
        return name
    }
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Venue

        if (id != other.id) return false

        return true
    }

    override fun hashCode() = id.hashCode()
}