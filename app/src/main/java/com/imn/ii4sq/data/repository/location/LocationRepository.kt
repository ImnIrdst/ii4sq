package com.imn.ii4sq.data.repository.location

import androidx.lifecycle.LiveData
import com.imn.ii4sq.domain.entities.LocationEntity
import com.imn.ii4sq.domain.entities.State

class LocationRepository(
    private val locationLiveData: LiveData<State<LocationEntity>>,
) {
    fun getLocationLiveData() = locationLiveData
}