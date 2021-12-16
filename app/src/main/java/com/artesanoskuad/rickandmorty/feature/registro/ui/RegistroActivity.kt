package com.artesanoskuad.rickandmorty.feature.registro.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.artesanoskuad.rickandmorty.databinding.ActivityRegistroBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class RegistroActivity : AppCompatActivity() {

    private val TAG = "Registro"
    private var rawBinding: ActivityRegistroBinding? = null
    private val binding: ActivityRegistroBinding get() = rawBinding!!

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        rawBinding = ActivityRegistroBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupClickListener()
        initFirebase()
    }

    private fun initFirebase() {
        auth = Firebase.auth
    }

    private fun setupClickListener() {
        binding.btnCrearCuenta?.setOnClickListener {
            createAccount(getEmail(), getPass())
        }
    }

    private fun getPass(): String {
        return binding.etPassword.text.toString()
    }

    private fun getEmail(): String {
        return binding.etEmail.text.toString()
    }

    private fun createAccount(email: String, password: String) {
        // [START create_user_with_email]
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d(TAG, "createUserWithEmail:success")
                    Toast.makeText(baseContext, "Usuario creado",
                        Toast.LENGTH_SHORT).show()
                    goToLoginView()
                } else {
                    // If sign in fails, display a message to the user.
                    Log.w(TAG, "createUserWithEmail:failure", task.exception)
                    Toast.makeText(baseContext, "No se pudo crear el usuario, verifique si ya existe",
                        Toast.LENGTH_SHORT).show()
                }
            }
    }

    private fun goToLoginView() {
        // Crear Login y llamarlo acá
    }

    override fun onDestroy() {
        super.onDestroy()
        rawBinding = null
    }
}