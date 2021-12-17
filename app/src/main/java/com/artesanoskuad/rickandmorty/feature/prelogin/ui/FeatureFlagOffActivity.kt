package com.artesanoskuad.rickandmorty.feature.prelogin.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.artesanoskuad.rickandmorty.R

class FeatureFlagOffActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feature_flag_off)
        obtainParamsBundle(intent.extras)
    }

    private fun obtainParamsBundle(extras: Bundle?) {
        extras?.let { safeBundle ->
            val minutos = safeBundle.getInt("minutos")
            showMessage(minutos)
        }
    }

    private fun showMessage(minutos: Int) {
        Toast.makeText(this, "La funcionalidad se prenderá en $minutos minutos", Toast.LENGTH_LONG).show()
    }
}