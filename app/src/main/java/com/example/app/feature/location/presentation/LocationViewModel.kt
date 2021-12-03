package com.example.app.feature.location.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.app.feature.location.data.LocationRepository
import com.example.app.feature.location.data.model.LocationResponse
import kotlinx.coroutines.launch
import retrofit2.Response

class LocationViewModel(private val locationRepository: LocationRepository) : ViewModel() {

    private val mutableState = MutableLiveData<LocationResponse>()
    fun state(): LiveData<LocationResponse> = mutableState

    fun getLocation() {
        viewModelScope.launch {
            val locaciones = locationRepository.getLocaciones()
            handleState(locaciones)
        }
    }

    private fun handleState(locaciones: Response<LocationResponse>) {
        if (locaciones.isSuccessful){
            handleBody(locaciones.body())
        }
    }

    private fun handleBody(body:LocationResponse?) {
        body?.let { safeBody ->
        mutableState.postValue(safeBody)
        }
    }

}