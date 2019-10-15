package com.github.szyrudnicki.poznanbikes.rest.model

import com.google.gson.annotations.SerializedName

data class GeometryResponseModel(
    @SerializedName("coordinates")
    val coordinates: List<Double>,
    @SerializedName("type")
    val type: String
)