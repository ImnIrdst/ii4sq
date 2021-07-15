package com.imn.ii4sq.domain.entities

data class Venue(
    val id: Long,
    val name: String,
    val location: VenueLocation,
)