package com.artesanoskuad.rickandmorty.feature.prelogin.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.artesanoskuad.rickandmorty.feature.prelogin.data.PreLoginDataRepository
import com.artesanoskuad.rickandmorty.feature.prelogin.presentation.PreLoginViewState.*
import kotlinx.coroutines.launch

class PreLoginViewModel(
    private val dataRepository: PreLoginDataRepository
) : ViewModel() {
    private val mutableLiveData = MutableLiveData<PreLoginViewState>()

    fun state(): LiveData<PreLoginViewState> = mutableLiveData

    fun checkPreLogin() {
        mutableLiveData.postValue(LoadPreLoginViewState)
        viewModelScope.launch {
            try {
                val response = dataRepository.prelogin()
                handleResponse(response)
            } catch (e: Exception) {
                e.printStackTrace()
                mutableLiveData.postValue(ServerErrorViewState)
            }
        }
    }

    private fun handleResponse(response: Boolean) {
        if (response) {
            mutableLiveData.postValue(SuccessPreLoginViewState)
        } else {
            mutableLiveData.postValue(FeatureOffViewState)
        }
    }
}