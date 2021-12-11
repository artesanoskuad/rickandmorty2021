package com.example.app.feature.prelogin.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.app.feature.prelogin.data.PreLoginDataRepository

class PreLoginViewModelFactory(
    private val preLoginDataRepository: PreLoginDataRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PreLoginViewModel::class.java)) {
            return PreLoginViewModel(preLoginDataRepository) as T
        }
        throw IllegalArgumentException("Unknow ViewModel class")
    }
}