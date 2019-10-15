package com.github.szyrudnicki.poznanbikes.rest.model

import com.google.gson.annotations.SerializedName

data class MapAPIResponseModel(
    @SerializedName("features")
    val stations: List<StationResponseModel>
)