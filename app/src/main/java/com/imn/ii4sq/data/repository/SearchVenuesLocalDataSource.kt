package com.imn.ii4sq.data.repository

import com.imn.ii4sq.domain.entities.Venue

interface SearchVenuesLocalDataSource {
    suspend fun insert(lat: Double, lon: Double, radius: Double, venues: List<Venue>)
    suspend fun search(lat: Double, lon: Double, radius: Double): List<Venue>?
}