package com.github.szyrudnicki.poznanbikes.model

import com.github.szyrudnicki.poznanbikes.rest.model.MapAPIResponseModel

object ModelMapper {
    fun mapResponseToDomain(response: MapAPIResponseModel): List<StationDomainModel> {
        val stations = mutableListOf<StationDomainModel>()
        response.stations.forEach {
            stations.add(
                StationDomainModel(
                    label = it.properties.label,
                    availableBikes = it.properties.bikes.toInt(),
                    freeRacks = it.properties.freeRacks.toInt(),
                    latitude = it.geometry.coordinates[1],
                    longitude = it.geometry.coordinates[0]
                )
            )
        }
        return stations
    }
}