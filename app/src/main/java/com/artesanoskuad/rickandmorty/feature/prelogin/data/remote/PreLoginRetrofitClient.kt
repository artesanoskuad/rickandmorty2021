package com.artesanoskuad.rickandmorty.feature.prelogin.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object PreLoginRetrofitClient {
    private const val URL_BASE = "http://192.168.1.3:3000/"

    fun crearPreLoginApi(): PreLoginApi {
        val retrofit = Retrofit.Builder()
            .baseUrl(URL_BASE)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(PreLoginApi::class.java)
    }
}