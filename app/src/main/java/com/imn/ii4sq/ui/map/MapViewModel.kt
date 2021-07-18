package com.imn.ii4sq.ui.map

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.imn.ii4sq.data.repository.location.LocationRepository
import com.imn.ii4sq.data.repository.search.SearchVenuesRepository
import com.imn.ii4sq.domain.entities.*
import com.imn.ii4sq.utils.distanceTo
import kotlinx.coroutines.launch
import java.lang.Exception

class MapViewModel(
    private val searchVenuesRepository: SearchVenuesRepository,
    private val locationRepository: LocationRepository
) : ViewModel() {

    private val venueSet = mutableSetOf<Venue>()

    private val _venuesList = MutableLiveData<State<List<Venue>>>()
    val venuesList: LiveData<State<List<Venue>>> = _venuesList

    val currentLocation: LiveData<State<LocationEntity>>
        get() = locationRepository.getLocationLiveData()

    fun search(location: LocationEntity, radius: Double) = viewModelScope.launch {

        _venuesList.postValue(loadingState())
        try {
            val result = searchVenuesRepository.search(location, radius)

            val newVenues = venueSet
                .apply { addAll(result) }
                .sortedBy { it.location.toLocationEntity().distanceTo(location) }
                .take(MARKERS_COUNT_LIMIT)

            venueSet.clear()
            venueSet.addAll(newVenues)

            _venuesList.postValue(successState(newVenues))
        } catch (e: Exception) {
            _venuesList.postValue(failureState(e.asIIError()))
        }
    }

    fun isVenueCleared(venue: Venue) = !venueSet.contains(venue)

    companion object {
        private const val MARKERS_COUNT_LIMIT = 25
    }
}