package com.example.app.feature.location.data.remote


class LocationsRepository (
    private val locationsApi: LocationsApi
) {
    suspend fun getLocations() = locationsApi.obtenerLocations()
}