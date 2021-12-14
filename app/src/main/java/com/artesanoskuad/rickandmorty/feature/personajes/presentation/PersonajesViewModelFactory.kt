package com.artesanoskuad.rickandmorty.feature.personajes.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.artesanoskuad.rickandmorty.feature.personajes.data.PersonajesRepository

class PersonajesViewModelFactory(
    private val repository: PersonajesRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PersonajesViewModel::class.java)) {
            return PersonajesViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}