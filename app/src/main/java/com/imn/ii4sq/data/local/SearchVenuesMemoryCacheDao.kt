package com.imn.ii4sq.data.local

import com.imn.ii4sq.data.repository.SearchVenuesLocalDataSource
import com.imn.ii4sq.domain.entities.Venue
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class SearchVenuesMemoryCacheDao(
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : SearchVenuesLocalDataSource {

    private val cache = mutableMapOf<String, List<Venue>>()

    override suspend fun insert(lat: Double, lon: Double, radius: Double, venues: List<Venue>) =
        withContext(ioDispatcher) {
            cache[getKey(lat, lon, radius)] = venues
        }

    override suspend fun search(lat: Double, lon: Double, radius: Double): List<Venue>? =
        withContext(ioDispatcher) {
            cache[getKey(lat, lon, radius)]
        }

    private fun getKey(lat: Double, lon: Double, radius: Double) = "$lat-$lon-$radius"
}

