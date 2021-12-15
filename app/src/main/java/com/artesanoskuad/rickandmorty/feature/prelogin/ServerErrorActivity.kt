package com.artesanoskuad.rickandmorty.feature.prelogin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.artesanoskuad.rickandmorty.databinding.ActivityServerErrorBinding

class ServerErrorActivity : AppCompatActivity() {
    private lateinit var binding: ActivityServerErrorBinding

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        binding = ActivityServerErrorBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setLottieAnimationProperties()
        setOnClickBtnVolverAIntentar()
    }

    private fun setLottieAnimationProperties() {
        with(binding.lavInternalServerError){
            setMinAndMaxFrame(20,50)
        }
    }

    private fun setOnClickBtnVolverAIntentar() {
        binding.btnVolverAIntentar.setOnClickListener {
            finish()
        }
    }
}