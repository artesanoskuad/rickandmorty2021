package com.artesanoskuad.rickandmorty.feature.productos.data.remote

import retrofit2.Response
import retrofit2.http.GET

interface ProductosApi {

    @GET("api/productos")
    suspend fun getAll() : Response<ProductoResponse>
}