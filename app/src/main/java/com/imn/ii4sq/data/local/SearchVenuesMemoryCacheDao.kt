package com.imn.ii4sq.data.local

import com.imn.ii4sq.data.repository.SearchVenuesLocalDataSource
import com.imn.ii4sq.domain.entities.Venue
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

class SearchVenuesMemoryCacheDao(
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
): SearchVenuesLocalDataSource {

    override suspend fun insert(lat: Double, lon: Double, radius: Double, venues: List<Venue>) {
        TODO("Not yet implemented")
    }

    override suspend fun search(lat: Double, lon: Double, radius: Double): List<Venue>? {
        TODO("Not yet implemented")
    }


}