package com.artesanoskuad.rickandmorty.feature.location.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import retrofit2.Response

class LocationViewModel(private val locationRepository: com.artesanoskuad.rickandmorty.feature.location.data.LocationRepository):ViewModel() {
    private val mutableState = MutableLiveData<com.artesanoskuad.rickandmorty.feature.location.data.model.LocationResponse>()
    fun state() : LiveData<com.artesanoskuad.rickandmorty.feature.location.data.model.LocationResponse> = mutableState
    fun getLocacion() {
        viewModelScope.launch {
            val locacion = locationRepository.getLocacion()
            handleState(locacion)
        }
    }

    private fun handleState(locacion: Response<com.artesanoskuad.rickandmorty.feature.location.data.model.LocationResponse>) {
        if (locacion.isSuccessful){
            handleBody(locacion.body())
        }else{
            //TODO
        }
    }

    private fun handleBody(body: com.artesanoskuad.rickandmorty.feature.location.data.model.LocationResponse?) {
        body?.let { safebody->
            mutableState.postValue(safebody)
        }
    }
}