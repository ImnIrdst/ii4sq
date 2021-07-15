package com.imn.ii4sq.utils

import com.google.gson.Gson
import com.imn.ii4sq.domain.entities.Venue

private val gson = Gson()
val testLat = 40.7099
val testLon = -73.9622
val testRadius = 200.1

val testSearchedVenues = gson.fromJson<List<Venue>>(testSearchJsonResponse)