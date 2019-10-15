package com.github.szyrudnicki.poznanbikes.rest.model

import com.google.gson.annotations.SerializedName

data class StationResponseModel(
    @SerializedName("geometry")
    val geometry: GeometryResponseModel,
    @SerializedName("id")
    val id: String,
    @SerializedName("properties")
    val properties: PropertiesResponseModel
)