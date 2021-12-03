package com.example.app.feature.location.data

import com.example.app.feature.location.data.remote.LocationApi

class LocationRepository(
    private val locacionApi: LocationApi
){
    suspend fun getLocaciones() = locacionApi.obtenerLocaciones()
}