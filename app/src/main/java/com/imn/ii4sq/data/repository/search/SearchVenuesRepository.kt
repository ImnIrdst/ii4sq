package com.imn.ii4sq.data.repository.search

import com.imn.ii4sq.domain.entities.LocationEntity
import com.imn.ii4sq.domain.entities.Venue
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class SearchVenuesRepository(
    private val searchVenuesRemoteDataSource: SearchVenuesRemoteDataSource,
    private val searchVenuesLocalDataSource: SearchVenuesLocalDataSource,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) {
    suspend fun search(location: LocationEntity, radius: Double): List<Venue> =
        withContext(ioDispatcher) {
            val localResult = searchVenuesLocalDataSource.search(location, radius)
            if (localResult == null) {
                val remoteResult = searchVenuesRemoteDataSource.search(
                    location.toLatLng(),
                    radius,
                    API_LOAD_LIMIT
                )
                searchVenuesLocalDataSource.insert(location, radius, remoteResult.response.venues)
                return@withContext remoteResult.response.venues
            } else {
                return@withContext localResult
            }
        }

    companion object {
        private const val API_LOAD_LIMIT = 10
    }
}