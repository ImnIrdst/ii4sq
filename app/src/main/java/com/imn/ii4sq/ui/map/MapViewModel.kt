package com.imn.ii4sq.ui.map

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.imn.ii4sq.data.repository.location.LocationRepository
import com.imn.ii4sq.data.repository.search.SearchVenuesRepository
import com.imn.ii4sq.domain.entities.*
import kotlinx.coroutines.launch

class MapViewModel(
    private val searchVenuesRepository: SearchVenuesRepository,
    private val locationRepository: LocationRepository
): ViewModel() {

    private val _venuesList = MutableLiveData<State<List<Venue>>>()
    val venuesList: LiveData<State<List<Venue>>> = _venuesList

    val location: LiveData<State<LocationEntity>>
        get() = locationRepository.getLocationLiveData()

    fun search(location: LocationEntity, radius: Double) = viewModelScope.launch {
        _venuesList.postValue(loadingState())

        val result = searchVenuesRepository.search(location, radius)

        _venuesList.postValue(successState(result))
    }
}