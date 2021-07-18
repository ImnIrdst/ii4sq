package com.imn.ii4sq.data.remote.details

import com.imn.ii4sq.data.repository.search.SearchVenuesRemoteDataSource
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface VenueDetailsApi: SearchVenuesRemoteDataSource {
    @GET("venues/{venueId}")
    suspend fun getVenueDetail(
        @Path("venueId") venueId: String
    ): VenueDetailsResponse
}