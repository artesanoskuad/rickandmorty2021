package com.example.app.feature.prelogin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.app.R
import com.example.app.databinding.ActivityServerErrorBinding

class ServerErrorActivity : AppCompatActivity() {
    private lateinit var binding: ActivityServerErrorBinding

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        binding = ActivityServerErrorBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setOnClickBtnVolverAIntentar()
    }
    private fun setOnClickBtnVolverAIntentar() {
        binding.btnVolverAIntentar.setOnClickListener {
            finish()
        }
    }
}