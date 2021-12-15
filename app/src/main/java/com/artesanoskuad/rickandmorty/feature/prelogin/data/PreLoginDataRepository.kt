package com.artesanoskuad.rickandmorty.feature.prelogin.data

import com.artesanoskuad.rickandmorty.feature.prelogin.data.remote.PreLoginApi


class PreLoginDataRepository(
    private val preLoginApi: PreLoginApi
) {
    suspend fun prelogin(): Boolean {
        val response = preLoginApi.prelogin()
        if (response.isSuccessful) {
            response.body()?.let { safeBody ->
                return safeBody.isEnabled
            }
        }
        return false
    }
}