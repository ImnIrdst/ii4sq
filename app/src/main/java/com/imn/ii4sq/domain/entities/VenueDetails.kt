package com.imn.ii4sq.domain.entities

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class VenueDetails(
    @SerializedName("id") val id: String,
    @SerializedName("name") val name: String,
    @SerializedName("category") val category: List<VenueCategory>,
    @SerializedName("location") val location: VenueLocation,
) : Parcelable {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as VenueDetails

        if (id != other.id) return false

        return true
    }

    override fun hashCode() = id.hashCode()
}