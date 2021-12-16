package com.artesanoskuad.rickandmorty.feature.splash

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.artesanoskuad.rickandmorty.R
import com.artesanoskuad.rickandmorty.feature.onboarding.OnboardingActivity
import com.artesanoskuad.rickandmorty.feature.prelogin.ui.PreLoginActivity


@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {

    private var isShowOnboarding = true
    private val ONBOARDING_PREF_NAME = "onboarding-pref"
    private val ONBOARDING_PREF_KEY = "onboarding-key"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        setupLottie()
        loadIsShowOnaboarding()
        setupSplash()
    }

    private fun setupLottie() {
        val imageView = findViewById<com.airbnb.lottie.LottieAnimationView>(R.id.animationView)
        imageView.setAnimation(R.raw.claus)
        imageView.playAnimation()

    }

    private fun loadIsShowOnaboarding() {
        val preferences: SharedPreferences =
            getSharedPreferences(ONBOARDING_PREF_NAME, Context.MODE_PRIVATE)
        isShowOnboarding = preferences.getBoolean(ONBOARDING_PREF_KEY, true)
    }

    private fun setupSplash() {
        val handler = Handler(Looper.getMainLooper())
        handler.postDelayed({
            goToNextView()
        }, 3000)
    }

    private fun goToNextView() {
        if (isShowOnboarding) {
            setOnboardingFalse()
            goToOnboarding()
        } else {
            goToPrelogin()
        }
    }

    private fun setOnboardingFalse() {
        val preferences: SharedPreferences =
            getSharedPreferences(ONBOARDING_PREF_NAME, Context.MODE_PRIVATE)
        val editor = preferences.edit()
        editor.putBoolean(ONBOARDING_PREF_KEY, false)
        editor.apply()
    }

    private fun goToOnboarding() {
        val intent = Intent(this, OnboardingActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun goToPrelogin() {
        val intent = Intent(this, PreLoginActivity::class.java)
        startActivity(intent)
        finish()
    }
}