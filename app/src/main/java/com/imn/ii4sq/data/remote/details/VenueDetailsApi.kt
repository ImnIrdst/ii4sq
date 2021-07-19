package com.imn.ii4sq.data.remote.details

import com.imn.ii4sq.data.repository.details.VenueDetailsRemoteDataSource
import retrofit2.http.GET
import retrofit2.http.Path

interface VenueDetailsApi: VenueDetailsRemoteDataSource {
    @GET("v2/venues/{venueId}")
    override suspend fun getVenueDetails(
        @Path("venueId") venueId: String
    ): VenueDetailsResponse
}