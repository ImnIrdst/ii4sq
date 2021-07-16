package com.imn.ii4sq.data.remote.search

import retrofit2.http.GET
import retrofit2.http.Query

interface SearchVenueApi {
    @GET("v2/venues/search")
    suspend fun searchVenue(
        @Query("ll") latLng: String,
        @Query("radius") radius: Int,
        @Query("limit") limit: Int,
    ): SearchResponse
}