package com.github.szyrudnicki.poznanbikes.model
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class StationDomainModel(
    val label: String,
    val availableBikes: Int,
    val freeRacks: Int,
    val latitude: Double,
    val longitude: Double
) : Parcelable