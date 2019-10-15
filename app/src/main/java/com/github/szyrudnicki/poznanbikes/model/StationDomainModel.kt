package com.github.szyrudnicki.poznanbikes.model

import android.location.Location

data class StationDomainModel(
    val label: String,
    val availableBikes: Int,
    val freeRacks: Int,
    val location: Location
)