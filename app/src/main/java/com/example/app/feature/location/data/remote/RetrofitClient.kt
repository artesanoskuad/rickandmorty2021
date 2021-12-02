package com.example.app.feature.location.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private const val URL_BASE = "https://rickandmortyapi.com/api/"
    private val retro = RetrofitClient
    fun getLocation(): LocationApi {
        val retrofit = Retrofit.Builder()
            .baseUrl(URL_BASE)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(LocationApi::class.java)
    }
}