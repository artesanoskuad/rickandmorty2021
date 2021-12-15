package com.artesanoskuad.rickandmorty.feature.prelogin.presentation

sealed class PreLoginViewState{
    object LoadPreLoginViewState : PreLoginViewState()
    object ServerErrorViewState : PreLoginViewState()
    object FeatureOffViewState : PreLoginViewState()
    object SuccessPreLoginViewState : PreLoginViewState()
}
