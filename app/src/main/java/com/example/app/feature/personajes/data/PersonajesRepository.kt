package com.example.app.feature.personajes.data

import com.example.app.feature.personajes.data.remote.PersonajesApi

class PersonajesRepository(
    private val personajesApi: PersonajesApi
) {
    suspend fun getPersonajes() = personajesApi.obtenerPersonajes()
}
