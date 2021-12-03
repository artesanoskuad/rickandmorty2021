package com.example.app.feature.location.data.remote

import com.example.app.feature.location.data.model.LocationResponse
import retrofit2.Response
import retrofit2.http.GET

interface LocationApi {
    @GET("location")
    suspend fun obtenerLocaciones() : Response<LocationResponse>
}