package com.imn.ii4sq.ui.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.imn.ii4sq.data.repository.details.VenueDetailsRepository
import com.imn.ii4sq.domain.entities.VenueDetails

class VenueDetailsViewModel(
    private val venueDetailsRepository: VenueDetailsRepository
) : ViewModel() {

    private val _venueDetails = MutableLiveData<VenueDetails>()
    val venueDetails: LiveData<VenueDetails> = _venueDetails

    fun loadVenueDetails(venueId: String) {
        TODO()
    }

    companion object {
        private const val MARKERS_COUNT_LIMIT = 25
    }
}