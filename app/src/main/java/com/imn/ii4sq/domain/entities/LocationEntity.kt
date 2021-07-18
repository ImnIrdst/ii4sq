package com.imn.ii4sq.domain.entities

data class LocationEntity(
    val latitude: Double,
    val longitude: Double,
){
    fun toLatLng() = "$latitude,$longitude"
}
