package com.example.app.feature.location.data.model

import com.example.app.common.data.model.Info

data class LocationsResponse(
    val info: Info,
    val results: List<Location>
)
