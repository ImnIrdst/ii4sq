package com.imn.ii4sq.data.local.search

import com.imn.ii4sq.data.repository.search.SearchVenuesLocalDataSource
import com.imn.ii4sq.domain.entities.LocationEntity
import com.imn.ii4sq.domain.entities.Venue
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class SearchVenuesMemoryCacheDao(
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : SearchVenuesLocalDataSource {

    private val cache = mutableMapOf<String, List<Venue>>()

    override suspend fun insert(location: LocationEntity, radius: Double, venues: List<Venue>) =
        withContext(ioDispatcher) {
            cache[getKey(location, radius)] = venues
        }

    override suspend fun search(location: LocationEntity, radius: Double): List<Venue>? =
        withContext(ioDispatcher) {
            cache[getKey(location, radius)]
        }

    private fun getKey(location: LocationEntity, radius: Double) = "${location.toLatLng()},$radius"
}

