package com.imn.ii4sq.ui.map

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.imn.ii4sq.data.repository.search.SearchVenuesRepository
import com.imn.ii4sq.domain.entities.State
import com.imn.ii4sq.domain.entities.Venue
import com.imn.ii4sq.domain.entities.loadingState
import com.imn.ii4sq.domain.entities.successState
import kotlinx.coroutines.launch

class MapViewModel(
    private val searchVenuesRepository: SearchVenuesRepository
): ViewModel() {
    private val _venuesList = MutableLiveData<State<List<Venue>>>()
    val venuesList: LiveData<State<List<Venue>>> = _venuesList

    fun search(lat: Double, lon: Double, radius: Double) = viewModelScope.launch {
        _venuesList.postValue(loadingState())

        val result = searchVenuesRepository.search(lat, lon, radius)

        _venuesList.postValue(successState(result))
    }
}