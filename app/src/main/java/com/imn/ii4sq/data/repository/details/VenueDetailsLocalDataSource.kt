package com.imn.ii4sq.data.repository.details

import com.imn.ii4sq.domain.entities.VenueDetails

interface VenueDetailsLocalDataSource {
    suspend fun insert(venueDetails: VenueDetails)
    suspend fun getVenueDetails(venueId: String): VenueDetails?
}
