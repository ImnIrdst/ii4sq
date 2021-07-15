package com.imn.ii4sq.utils

import com.google.gson.Gson
import com.imn.ii4sq.data.remote.search.SearchResponse

const val testLat = 40.7099
const val testLon = -73.9622
const val testRadius = 200.1

private val gson = Gson()
val testSearchedVenues = gson.fromJson<SearchResponse>(testSearchJsonResponse).response.venues