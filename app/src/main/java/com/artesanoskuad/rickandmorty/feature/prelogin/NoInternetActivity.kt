package com.artesanoskuad.rickandmorty.feature.prelogin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.artesanoskuad.rickandmorty.databinding.ActivityNoInternetBinding

class NoInternetActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNoInternetBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNoInternetBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setLottieAnimationProperties()
        setOnClickBtnVolverAIntentar()
    }

    private fun setLottieAnimationProperties() {
        with(binding.lavNoInternetError){
            setMinAndMaxFrame(5, 60)
        }
    }

    private fun setOnClickBtnVolverAIntentar() {
        binding.btnReintentar.setOnClickListener {
            finish()
        }
    }
}