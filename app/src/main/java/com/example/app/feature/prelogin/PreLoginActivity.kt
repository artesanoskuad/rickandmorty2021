package com.example.app.feature.prelogin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.app.R

class PreLoginActivity : AppCompatActivity() {

    private val isRootDevice = false
    private val isInternetConexionOff = false
    private val isServerError = false
    private val isFeatureFlagOff = false
    private val isBiometricOn = true


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pre_login)
        if(isRootDevice){
            val intent = Intent(this, RootDeviceActivity::class.java)
            startActivity(intent)
            finish()
        }

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
}