package com.imn.ii4sq.utils

import com.google.gson.Gson
import com.imn.ii4sq.data.remote.search.SearchResponse
import com.imn.ii4sq.domain.entities.LocationEntity

const val testLat = 40.7099
const val testLon = -73.9622
const val testRadius = 200.1

val testLocation = LocationEntity(testLat, testLon)

private val gson = Gson()
val testSearchResponse = gson.fromJson<SearchResponse>(testSearchJsonResponse)
val testSearchedVenues = testSearchResponse.response.venues

const val TEST_AWAIT_TIMEOUT = 1000L