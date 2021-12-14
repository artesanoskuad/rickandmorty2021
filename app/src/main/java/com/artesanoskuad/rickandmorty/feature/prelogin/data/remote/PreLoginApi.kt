package com.artesanoskuad.rickandmorty.feature.prelogin.data.remote

import retrofit2.Response
import retrofit2.http.GET

interface PreLoginApi {
    @GET("api/prelogin")
    suspend fun prelogin() : Response<PreLoginModel>
}