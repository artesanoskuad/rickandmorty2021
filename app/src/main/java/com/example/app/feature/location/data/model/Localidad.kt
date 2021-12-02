package com.example.app.feature.location.data.model

import com.example.app.feature.personajes.data.model.Location
import com.example.app.feature.personajes.data.model.Origen

data class Localidad(
    val id: Int,
    val name: String,
    val type: String,
    val dimension: String,
    val residents: List<String>,
    val url: String,
    val created: String
)
