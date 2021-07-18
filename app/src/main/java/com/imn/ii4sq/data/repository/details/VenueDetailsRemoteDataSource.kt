package com.imn.ii4sq.data.repository.details

import com.imn.ii4sq.data.remote.details.VenueDetailsResponse

interface VenueDetailsRemoteDataSource {
    suspend fun getVenueDetails(venueId: String): VenueDetailsResponse
}
