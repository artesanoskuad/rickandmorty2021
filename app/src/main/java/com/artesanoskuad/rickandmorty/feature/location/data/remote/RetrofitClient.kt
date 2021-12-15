package com.artesanoskuad.rickandmorty.feature.location.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private const val URL_BASE = "https://rickandmortyapi.com/api/"
    private val retro = com.artesanoskuad.rickandmorty.feature.location.data.remote.RetrofitClient
    fun getLocation(): com.artesanoskuad.rickandmorty.feature.location.data.remote.LocationApi {
        val retrofit = Retrofit.Builder()
            .baseUrl(com.artesanoskuad.rickandmorty.feature.location.data.remote.RetrofitClient.URL_BASE)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(com.artesanoskuad.rickandmorty.feature.location.data.remote.LocationApi::class.java)
    }
}