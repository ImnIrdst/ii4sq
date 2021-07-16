package com.imn.ii4sq.data.repository.search

import com.imn.ii4sq.data.remote.search.SearchResponse

interface SearchVenuesRemoteDataSource {
    suspend fun search(latLng: String, radius: Double, limit: Int): SearchResponse
}