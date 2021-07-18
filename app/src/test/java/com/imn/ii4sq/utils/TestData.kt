package com.imn.ii4sq.utils

import com.google.gson.Gson
import com.imn.ii4sq.data.remote.details.VenueDetailsResponse
import com.imn.ii4sq.data.remote.search.SearchResponse
import com.imn.ii4sq.domain.entities.LocationEntity
import java.net.UnknownHostException

const val testRadius = 200.1

val testLocation = LocationEntity(40.7099, -73.9622)
val testUnknownHostException = UnknownHostException("uhe")

private val gson = Gson()
val testSearchResponse = gson.fromJson<SearchResponse>(testSearchJsonResponse)
val testSearchedVenues = testSearchResponse.response.venues

val testSearchResponseAfterPan = gson.fromJson<SearchResponse>(testSearchJsonResponseAfterPan)
val testSearchedVenuesAfterPan = testSearchResponseAfterPan.response.venues
val testVenue = testSearchedVenuesAfterPan[0]
val testLocationAfterPan = testSearchedVenuesAfterPan[0].location.toLocationEntity()

val testVenueDetailsResponse = gson.fromJson<VenueDetailsResponse>(testVenueDetailsJsonResponse)
val testVenueDetails = testVenueDetailsResponse.response.venue

const val TEST_AWAIT_TIMEOUT = 1000L