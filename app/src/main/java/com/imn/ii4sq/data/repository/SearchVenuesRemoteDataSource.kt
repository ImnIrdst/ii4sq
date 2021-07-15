package com.imn.ii4sq.data.repository

import com.imn.ii4sq.domain.entities.Venue

interface SearchVenuesRemoteDataSource {
    suspend fun search(lat: Double, lon: Double, radius: Double): List<Venue>
}