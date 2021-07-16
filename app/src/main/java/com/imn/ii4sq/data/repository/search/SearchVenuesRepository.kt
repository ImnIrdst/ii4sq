package com.imn.ii4sq.data.repository.search

import com.imn.ii4sq.domain.entities.Venue
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class SearchVenuesRepository(
    private val searchVenuesRemoteDataSource: SearchVenuesRemoteDataSource,
    private val searchVenuesLocalDataSource: SearchVenuesLocalDataSource,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) {
    suspend fun search(lat: Double, lon: Double, radius: Double): List<Venue> =
        withContext(ioDispatcher) {
            val localResult = searchVenuesLocalDataSource.search(lat, lon, radius)
            if (localResult == null) {
                val remoteResult = searchVenuesRemoteDataSource.search(lat, lon, radius)
                searchVenuesLocalDataSource.insert(lat, lon, radius, remoteResult)
                return@withContext remoteResult
            } else {
                return@withContext localResult
            }
        }
}