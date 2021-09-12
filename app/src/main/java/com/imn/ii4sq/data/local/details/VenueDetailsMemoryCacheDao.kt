package com.imn.ii4sq.data.local.details

import com.imn.ii4sq.data.repository.details.VenueDetailsLocalDataSource
import com.imn.ii4sq.domain.entities.VenueDetails
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class VenueDetailsMemoryCacheDao(
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : VenueDetailsLocalDataSource {
    private val cache = mutableMapOf<String, VenueDetails>()

    override suspend fun insert(venueDetails: VenueDetails) =
        withContext(ioDispatcher) {
            cache[venueDetails.id] = venueDetails
        }

    override suspend fun getVenueDetails(venueId: String): VenueDetails? =
        withContext(ioDispatcher) {
            cache[venueId]
        }
}
