package com.imn.ii4sq.data.remote.details

import com.google.gson.annotations.SerializedName
import com.imn.ii4sq.domain.entities.VenueDetails

data class VenueDetailsResponse(
    @SerializedName("response") val response: Response,
) {
    fun toVenueDetails() = response.venue

    companion object {
        data class Response(
            @SerializedName("venue")  val venue: VenueDetails
        )
    }
}