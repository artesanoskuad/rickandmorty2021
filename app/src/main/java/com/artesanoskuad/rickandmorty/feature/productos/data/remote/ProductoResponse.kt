package com.artesanoskuad.rickandmorty.feature.productos.data.remote

import com.artesanoskuad.rickandmorty.feature.productos.data.model.Producto
import com.artesanoskuad.rickandmorty.feature.productos.data.model.State

data class ProductoResponse(
    val state: State,
    val products: List<Producto>?
)
