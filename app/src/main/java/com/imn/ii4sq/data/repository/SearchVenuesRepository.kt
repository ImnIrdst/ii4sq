package com.imn.ii4sq.data.repository

import com.imn.ii4sq.domain.entities.Venue

class SearchVenuesRepository(
    private val searchVenuesRemoteDataSource: SearchVenuesRemoteDataSource
) {
    suspend fun search(lat: Double, lon: Double, radius: Double): List<Venue> {
        return searchVenuesRemoteDataSource.search(lat, lon ,radius)
    }
}