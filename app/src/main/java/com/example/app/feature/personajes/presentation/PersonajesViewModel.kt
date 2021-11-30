package com.example.app.feature.personajes.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.app.feature.personajes.data.PersonajesRepository
import com.example.app.feature.personajes.data.model.PersonajesResponse
import kotlinx.coroutines.launch
import retrofit2.Response

class PersonajesViewModel(private val personjesRepository: PersonajesRepository) : ViewModel() {

    private val mutableState = MutableLiveData<PersonajesResponse>()
    fun state() : LiveData<PersonajesResponse> = mutableState

    fun getPersonajes() {
        viewModelScope.launch {
            val personajes = personjesRepository.getPersonajes()
            handleState(personajes)
        }
    }

    private fun handleState(personajes: Response<PersonajesResponse>) {
        if(personajes.isSuccessful){
             handleBody(personajes.body())
        } else {
            // Todo mostrar mensaje de error en la vista
        }
    }

    private fun handleBody(body: PersonajesResponse?) {
        body?.let { safeBody ->
            mutableState.postValue(safeBody)
        }
    }

}