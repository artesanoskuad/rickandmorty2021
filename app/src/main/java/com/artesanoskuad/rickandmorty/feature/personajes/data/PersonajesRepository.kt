package com.artesanoskuad.rickandmorty.feature.personajes.data

import com.artesanoskuad.rickandmorty.feature.personajes.data.remote.PersonajesApi

class PersonajesRepository(
    private val personajesApi: PersonajesApi
) {
    suspend fun getPersonajes() = personajesApi.obtenerPersonajes()
}
