package com.github.szyrudnicki.poznanbikes.rest.model


import com.google.gson.annotations.SerializedName

data class PropertiesResponseModel(
    @SerializedName("free_racks")
    val freeRacks: String,
    @SerializedName("bikes")
    val bikes: String,
    @SerializedName("label")
    val label: String,
    @SerializedName("bike_racks")
    val bikeRacks: String,
    @SerializedName("updated")
    val updated: String
)