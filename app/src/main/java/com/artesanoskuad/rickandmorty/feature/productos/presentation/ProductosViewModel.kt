package com.artesanoskuad.rickandmorty.feature.productos.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.artesanoskuad.rickandmorty.core.exception.ServerException
import com.artesanoskuad.rickandmorty.feature.productos.data.ProductosDataRepository
import com.artesanoskuad.rickandmorty.feature.productos.data.model.Producto
import com.artesanoskuad.rickandmorty.feature.productos.data.remote.ProductoResponse
import com.artesanoskuad.rickandmorty.feature.productos.presentation.ProductosViewState.*
import kotlinx.coroutines.launch
import java.lang.Exception

class ProductosViewModel(
    private val repository: ProductosDataRepository
) : ViewModel() {

    private val mutableLiveData = MutableLiveData<ProductosViewState>()

    fun state(): LiveData<ProductosViewState> = mutableLiveData

    fun obtenerProductos() {
        mutableLiveData.postValue(CargandoProductosViewState)
        viewModelScope.launch {
            try {
                val productos = repository.getProductos()
                handleResponse(productos)
            } catch (serverException: ServerException) {
                mutableLiveData.postValue(ServerErrorViewState)
            } catch (exception: Exception){
                exception.printStackTrace()
                mutableLiveData.postValue(NoHayInternetViewState)
            }
        }
    }

    private fun handleResponse(productos: ProductoResponse) {
        val state = productos.state
        if(state.enabled){
            handleProductList(productos.products)
        } else {
            mutableLiveData.postValue(FeatureOffViewState(state.uptime))
        }
    }

    private fun handleProductList(productos: List<Producto>?) {
        productos?.let { safeProductos ->
            if(safeProductos.isEmpty()){
                mutableLiveData.postValue(MostrarListaVaciaViewState)
            } else {
                mutableLiveData.postValue(MostrarProductosViewState(safeProductos))
            }
        }
    }
}
