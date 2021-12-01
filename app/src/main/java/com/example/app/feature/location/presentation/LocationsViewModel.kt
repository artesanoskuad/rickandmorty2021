package com.example.app.feature.location.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.app.feature.location.data.model.LocationsResponse
import com.example.app.feature.location.data.remote.LocationsRepository
import com.example.app.feature.personajes.data.model.PersonajesResponse
import kotlinx.coroutines.launch
import retrofit2.Response


class LocationsViewModel(private val locationsRepository: LocationsRepository) : ViewModel(){

    private val mutableState = MutableLiveData<LocationsResponse>()
    fun state() : MutableLiveData<LocationsResponse> = mutableState

    fun getLocations() {
        viewModelScope.launch {
            val locations = locationsRepository.getLocations()
            handleState(locations)
        }
    }

    private fun handleState(locations: Response<LocationsResponse>) {
        if(locations.isSuccessful){
            handleBody(locations.body())
        } else {
            // Todo mostrar mensaje de error en la vista
        }

}

    private fun handleBody(body: LocationsResponse?) {
        body?.let{safeBody->
            mutableState.postValue(safeBody)
        }
    }

    }
