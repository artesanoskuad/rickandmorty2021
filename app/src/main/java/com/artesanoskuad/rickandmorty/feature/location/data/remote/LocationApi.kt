package com.artesanoskuad.rickandmorty.feature.location.data.remote

import retrofit2.Response
import retrofit2.http.GET

interface LocationApi {
    @GET("location")
    suspend fun obtenerLocalidad() : Response<com.artesanoskuad.rickandmorty.feature.location.data.model.LocationResponse>
}