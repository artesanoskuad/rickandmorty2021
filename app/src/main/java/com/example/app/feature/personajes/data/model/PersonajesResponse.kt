package com.example.app.feature.personajes.data.model

import com.example.app.common.data.model.Info

data class PersonajesResponse(
    val info: Info,
    val results: List<Personaje>
)