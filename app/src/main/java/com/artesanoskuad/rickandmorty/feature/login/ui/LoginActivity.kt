package com.artesanoskuad.rickandmorty.feature.login.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.artesanoskuad.rickandmorty.databinding.ActivityLoginBinding
import com.artesanoskuad.rickandmorty.databinding.ActivityRegistroBinding
import com.artesanoskuad.rickandmorty.feature.home.ui.HomeActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LoginActivity : AppCompatActivity() {

    private val TAG = "Login"
    private var rawBinding: ActivityLoginBinding? = null
    private val binding: ActivityLoginBinding get() = rawBinding!!

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        rawBinding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupClickListener()
        initFirebase()
    }

    private fun initFirebase() {
        auth = Firebase.auth
    }

    private fun setupClickListener() {
        binding.btnLogin.setOnClickListener {
            loginAccount(getEmail(), getPass())
        }
    }

    private fun getPass(): String {
        return binding.etPassword.text.toString()
    }

    private fun getEmail(): String {
        return binding.etEmail.text.toString()
    }

    private fun loginAccount(email: String, password: String) {
        // [START create_user_with_email]
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d(TAG, "loginUserWithEmail:success")
                    Toast.makeText(baseContext, "Usuario Logueado",
                        Toast.LENGTH_SHORT).show()
                    goToHomeView()
                } else {
                    // If sign in fails, display a message to the user.
                    Log.w(TAG, "createUserWithEmail:failure", task.exception)
                    Toast.makeText(baseContext, "No se pudo loguear la app, create una cuenta",
                        Toast.LENGTH_SHORT).show()
                }
            }
    }

    private fun goToHomeView() {
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
        finish()
    }

    override fun onDestroy() {
        super.onDestroy()
        rawBinding = null
    }
}