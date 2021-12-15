package com.artesanoskuad.rickandmorty.feature.location.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException

class LocationViewModelFactory(private val repository: com.artesanoskuad.rickandmorty.feature.location.data.LocationRepository):ViewModelProvider.Factory {
    override fun<T: ViewModel>create(modelClass: Class<T>):T{
        if (modelClass.isAssignableFrom(LocationViewModel::class.java)){
            return LocationViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknow ViewModel class")
    }
}