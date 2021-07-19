package com.imn.ii4sq.ui.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.imn.ii4sq.data.repository.details.VenueDetailsRepository
import com.imn.ii4sq.domain.entities.*
import kotlinx.coroutines.launch

class VenueDetailsViewModel(
    private val venueDetailsRepository: VenueDetailsRepository
) : ViewModel() {

    private val _venueDetails = MutableLiveData<State<VenueDetails>>()
    val venueDetails: LiveData<State<VenueDetails>> = _venueDetails

    fun loadVenueDetails(venueId: String) = viewModelScope.launch {
        _venueDetails.postValue(loadingState())
        try {
            val result = venueDetailsRepository.getVenueDetails(venueId)

            _venueDetails.postValue(successState(result))
        } catch (e: Exception) {
            _venueDetails.postValue(failureState(e.asIIError()))
        }
    }
}