package com.github.szyrudnicki.poznanbikes.model

import android.location.Location
import android.location.LocationManager
import com.github.szyrudnicki.poznanbikes.rest.model.MapAPIResponseModel
import com.github.szyrudnicki.poznanbikes.rest.model.StationResponseModel

object ModelMapper {
    fun mapResponseToDomain(response: MapAPIResponseModel) : List<StationDomainModel> {
        val stations = mutableListOf<StationDomainModel>()
        response.stations.forEach {
            stations.add(
                StationDomainModel(
                    label = it.properties.label,
                    availableBikes = it.properties.bikes.toInt(),
                    freeRacks = it.properties.freeRacks.toInt(),
                    location = Location(LocationManager.GPS_PROVIDER).apply {
                        latitude = it.geometry.coordinates[0]
                        longitude = it.geometry.coordinates[1]
                    }
                )
            )
        }
        return stations
    }
}