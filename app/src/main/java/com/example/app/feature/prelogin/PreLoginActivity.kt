package com.example.app.feature.prelogin

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.app.R
import com.scottyab.rootbeer.RootBeer

class PreLoginActivity : AppCompatActivity() {

    private val isInternetConexionOff = false
    private val isServerError = false
    private val isFeatureFlagOff = false
    private val isBiometricOn = true


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pre_login)
        checkRootDevice()
        checkInternetConnection()

        if(isInternetConexionOff){
            val intent = Intent(this, NoInternetActivity::class.java)
            startActivity(intent)
        }

        if(isServerError){
            val intent = Intent(this, NoInternetActivity::class.java)
            startActivity(intent)
        }

        if(isFeatureFlagOff){
            val intent = Intent(this, FeatureFlagOffActivity::class.java)
            startActivity(intent)
        }

        if(isBiometricOn){
            val intent = Intent(this, BiometricActivity::class.java)
            startActivity(intent)
        }

    }

    private fun checkInternetConnection() {
        val connectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val network = connectivityManager.activeNetwork
            val activeNetwork = connectivityManager.getNetworkCapabilities(network)
        } else {

        }
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