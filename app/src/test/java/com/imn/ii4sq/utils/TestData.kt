package com.imn.ii4sq.utils

import com.google.gson.Gson
import com.imn.ii4sq.data.remote.search.SearchResponse
import com.imn.ii4sq.domain.entities.LocationEntity

const val testLat = 40.7099
const val testLon = -73.9622
const val testRadius = 200.1

val testLocation = LocationEntity(40.7099, -73.9622)

private val gson = Gson()
val testSearchResponse = gson.fromJson<SearchResponse>(testSearchJsonResponse)
val testSearchedVenues = testSearchResponse.response.venues

val testSearchResponseAfterPan = gson.fromJson<SearchResponse>(testSearchJsonResponseAfterPan)
val testSearchedVenuesAfterPan = testSearchResponseAfterPan.response.venues
val testVenue = testSearchedVenuesAfterPan[0]
val testLocationAfterPan = testSearchedVenuesAfterPan[0].location.toLocationEntity()

const val TEST_AWAIT_TIMEOUT = 1000L