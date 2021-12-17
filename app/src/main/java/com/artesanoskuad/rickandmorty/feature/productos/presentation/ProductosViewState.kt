package com.artesanoskuad.rickandmorty.feature.productos.presentation

import com.artesanoskuad.rickandmorty.feature.productos.data.model.Producto

sealed class ProductosViewState {
    object CargandoProductosViewState : ProductosViewState()
    data class MostrarProductosViewState(val productos : List<Producto>) : ProductosViewState()
    object MostrarListaVaciaViewState : ProductosViewState()
    object NoHayInternetViewState : ProductosViewState()
    data class FeatureOffViewState(val minutos: Int?) : ProductosViewState()
    object ServerErrorViewState : ProductosViewState()
}
