package com.artesanoskuad.rickandmorty.feature.location.data

class LocationRepository(private val locationApi: com.artesanoskuad.rickandmorty.feature.location.data.remote.LocationApi) {
    suspend fun getLocacion() = locationApi.obtenerLocalidad()
}