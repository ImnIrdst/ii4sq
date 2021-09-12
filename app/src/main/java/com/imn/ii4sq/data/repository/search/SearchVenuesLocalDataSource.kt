package com.imn.ii4sq.data.repository.search

import com.imn.ii4sq.domain.entities.LocationEntity
import com.imn.ii4sq.domain.entities.Venue

interface SearchVenuesLocalDataSource {
    suspend fun insert(location: LocationEntity, radius: Double, venues: List<Venue>)
    suspend fun search(location: LocationEntity, radius: Double): List<Venue>?
}
