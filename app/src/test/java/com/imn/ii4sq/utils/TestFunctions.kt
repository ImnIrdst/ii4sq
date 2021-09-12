package com.imn.ii4sq.utils

import com.imn.ii4sq.domain.entities.LocationEntity
import kotlin.math.pow
import kotlin.math.sqrt

fun LocationEntity.distanceToTest(other: LocationEntity) =
    sqrt((this.latitude - other.latitude).pow(2) + (this.longitude - other.longitude).pow(2))
