package com.example.app.feature.location.data

import com.example.app.feature.location.data.remote.LocationApi

class LocationRepository(private val locationApi: LocationApi) {
    suspend fun getLocacion() = locationApi.obtenerLocalidad()
}