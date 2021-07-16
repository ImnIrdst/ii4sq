package com.imn.ii4sq.data.repository.search

import com.imn.ii4sq.data.remote.search.SearchResponse
import com.imn.ii4sq.domain.entities.LocationEntity

interface SearchVenuesRemoteDataSource {
    suspend fun search(latLng: String, radius: Double): SearchResponse
}