package com.example.app.feature.location.data.remote

import com.example.app.feature.personajes.data.remote.RetrofitClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private const val URL_BASE = "https://rickandmortyapi.com/api/"
    private val retro = RetrofitClient
    fun getLocationsApi(): LocationsApi {
        val retrofit = Retrofit.Builder()
            .baseUrl(URL_BASE)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(LocationsApi::class.java)
    }
}