package com.example.app.feature.prelogin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.app.R

class PreLoginActivity : AppCompatActivity() {

    private val isRootDevice = false
    private val isInternetConexionOff = false
    private val isServerError = true
    private val isFeatureFlagOff = false
    private val isBiometricOn = false


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
            val intent = Intent(this, ServerErrorActivity::class.java)
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