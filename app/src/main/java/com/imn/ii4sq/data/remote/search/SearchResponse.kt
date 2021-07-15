package com.imn.ii4sq.data.remote.search

import com.google.gson.annotations.SerializedName
import com.imn.ii4sq.domain.entities.Venue

data class SearchResponse(
    @SerializedName("response") val response: Response,
) {
    companion object {
        data class Response(
            @SerializedName("venues")  val venues: List<Venue>
        )
    }
}

