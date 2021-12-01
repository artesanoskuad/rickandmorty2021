package com.example.app.feature.location.data.remote

import com.example.app.feature.location.data.model.LocationsResponse
import com.example.app.feature.personajes.data.model.PersonajesResponse
import retrofit2.Response
import retrofit2.http.GET

interface LocationsApi {
    @GET("location")
    suspend fun obtenerLocations() : Response<LocationsResponse>
}