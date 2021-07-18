package com.imn.ii4sq.data.repository.details

import com.imn.ii4sq.domain.entities.VenueDetails
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class VenueDetailsRepository(
    private val venueDetailsRemoteDataSource: VenueDetailsRemoteDataSource,
    private val venueDetailsLocalDataSource: VenueDetailsLocalDataSource,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) {
    suspend fun getVenueDetails(venueId: String): VenueDetails =
        withContext(ioDispatcher) {
            val localResult = venueDetailsLocalDataSource.getVenueDetails(venueId)
            if (localResult == null) {
                val remoteResult = venueDetailsRemoteDataSource.getVenueDetails(venueId)
                venueDetailsLocalDataSource.insert(remoteResult.toVenueDetails())
                return@withContext remoteResult.toVenueDetails()
            } else {
                return@withContext localResult
            }
        }
}