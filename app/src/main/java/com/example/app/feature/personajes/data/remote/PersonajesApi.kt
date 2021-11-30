package com.example.app.feature.personajes.data.remote

import com.example.app.feature.personajes.data.model.PersonajesResponse
import retrofit2.Response
import retrofit2.http.GET

interface PersonajesApi {

    @GET("/character")
    suspend fun obtenerPersonajes() : Response<PersonajesResponse>

}