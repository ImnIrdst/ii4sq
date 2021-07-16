package com.imn.ii4sq.data.remote.search

import com.imn.ii4sq.data.repository.search.SearchVenuesRemoteDataSource
import retrofit2.http.GET
import retrofit2.http.Query

interface SearchVenueApi: SearchVenuesRemoteDataSource {
    @GET("v2/venues/search")
    override suspend fun search(
        @Query("ll") latLng: String,
        @Query("radius") radius: Double,
    ): SearchResponse
}