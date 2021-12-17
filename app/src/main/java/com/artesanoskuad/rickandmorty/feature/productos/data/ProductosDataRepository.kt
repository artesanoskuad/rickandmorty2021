package com.artesanoskuad.rickandmorty.feature.productos.data

import com.artesanoskuad.rickandmorty.core.exception.ServerException
import com.artesanoskuad.rickandmorty.feature.productos.data.remote.ProductoResponse
import com.artesanoskuad.rickandmorty.feature.productos.data.remote.ProductosApi

class ProductosDataRepository(private val remoteApi: ProductosApi) {

    suspend fun getProductos(): ProductoResponse {
        val response = remoteApi.getAll()
        val body = response.body()
        if (body == null) {
            throw ServerException()
        } else {
            return body
        }
    }

}