package com.artesanoskuad.rickandmorty.feature.prelogin

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.artesanoskuad.rickandmorty.R
import com.artesanoskuad.rickandmorty.feature.prelogin.data.PreLoginDataRepository
import com.artesanoskuad.rickandmorty.feature.prelogin.data.remote.PreLoginApi
import com.artesanoskuad.rickandmorty.feature.prelogin.data.remote.PreLoginRetrofitClient
import com.artesanoskuad.rickandmorty.feature.prelogin.presentation.PreLoginViewModel
import com.artesanoskuad.rickandmorty.feature.prelogin.presentation.PreLoginViewModelFactory
import com.artesanoskuad.rickandmorty.feature.prelogin.presentation.PreLoginViewState
import com.artesanoskuad.rickandmorty.feature.prelogin.presentation.PreLoginViewState.*
import com.scottyab.rootbeer.RootBeer

class PreLoginActivity : AppCompatActivity() {

    lateinit var preLoginApi: PreLoginApi
    lateinit var preLoginDataRepository: PreLoginDataRepository
    lateinit var preLoginViewModelFactory: PreLoginViewModelFactory
    lateinit var preLoginViewModel: PreLoginViewModel
    private val isBiometricOn = true


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pre_login)
        checkRootDevice()
        checkInternetConnection()
        initDependencies()
        setupViewModel()

        /*
        if (isBiometricOn) {
            val intent = Intent(this, BiometricActivity::class.java)
            startActivity(intent)
        }*/

    }

    override fun onResume() {
        super.onResume()
        preLoginViewModel.checkPreLogin()
    }

    private fun initDependencies() {
        preLoginApi = PreLoginRetrofitClient.crearPreLoginApi()
        preLoginDataRepository = PreLoginDataRepository(preLoginApi)
        preLoginViewModelFactory = PreLoginViewModelFactory(preLoginDataRepository)
        preLoginViewModel = ViewModelProvider(this, preLoginViewModelFactory)[PreLoginViewModel::class.java]
    }

    private fun setupViewModel() {
        preLoginViewModel.state().observe(this){
            it?.let { safeSate ->
                handleState(safeSate)
            }
        }
    }

    private fun handleState(safeSate: PreLoginViewState) {
        when(safeSate){
            is LoadPreLoginViewState -> showProgressView()
            is ServerErrorViewState -> goToServerErrorView()
            is FeatureOffViewState -> goToFeatureOffView()
            is SuccessPreLoginViewState -> showPreLoginView()
        }
    }

    private fun showProgressView() {
        Toast.makeText(this, "Cargando datos", Toast.LENGTH_SHORT).show()
    }

    private fun goToServerErrorView() {
        val intent = Intent(this, ServerErrorViewState::class.java)
        startActivity(intent)
    }

    private fun goToFeatureOffView() {
        val intent = Intent(this, FeatureFlagOffActivity::class.java)
        startActivity(intent)
    }

    private fun showPreLoginView() {
        Log.d("PreLogin", "Success PreLogin")
    }

    private fun checkInternetConnection() {
        val connectivityManager =
            getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        val network = connectivityManager.activeNetwork
        val activeNetwork = connectivityManager.getNetworkCapabilities(network)
        val isWiffyConnected =
            activeNetwork?.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) ?: false
        val isPlanDeDatosConnected =
            activeNetwork?.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) ?: false
        if (isWiffyConnected.not() && isPlanDeDatosConnected.not()) {
            goToNoInternetView()
        }
    }

    private fun goToNoInternetView() {
        val intent = Intent(this, NoInternetActivity::class.java)
        startActivity(intent)
    }

    /**
     *  Esta función valida si el dispositivo se encuentra Rooteado.
     *  Se puede obtener mas información sobre la biblioteca RootBeer en
     *  la siguiente url: https://github.com/scottyab/rootbeer
     * */
    private fun checkRootDevice() {
        val rootBeer = RootBeer(this)
        if (rootBeer.isRooted) {
            val intent = Intent(this, RootDeviceActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}