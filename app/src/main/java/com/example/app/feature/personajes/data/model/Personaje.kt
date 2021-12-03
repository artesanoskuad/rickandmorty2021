package com.example.app.feature.personajes.data.model

data class Personaje(
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String,
    val origen: Origen,
    val location: Location,
    val image: String,
    val episode: List<String>,
    val url: String,
    val created: String
)