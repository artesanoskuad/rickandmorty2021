package com.example.app.feature.location.data.model

import com.example.app.feature.personajes.data.model.Info
import com.example.app.feature.personajes.data.model.Location

data class LocationResponse (
    val info: Info,
    val results: List<Localidad>
)

