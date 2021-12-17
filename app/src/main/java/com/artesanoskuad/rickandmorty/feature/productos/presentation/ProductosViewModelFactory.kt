package com.artesanoskuad.rickandmorty.feature.productos.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.artesanoskuad.rickandmorty.feature.prelogin.data.PreLoginDataRepository
import com.artesanoskuad.rickandmorty.feature.productos.data.ProductosDataRepository

class ProductosViewModelFactory(
    private val repository: ProductosDataRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ProductosViewModel::class.java)) {
            return ProductosViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknow ViewModel class")
    }
}