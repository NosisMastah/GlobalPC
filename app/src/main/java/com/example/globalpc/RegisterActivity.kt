package com.example.globalpc

import android.app.Activity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

@Suppress("SpellCheckingInspection")
class RegisterActivity : Activity() {
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.regist_activity)

        // Initialize Firebase Auth
        auth = Firebase.auth
    }

    private fun createAccount(email: String, password: String) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    exibirToast("Conta  com sucesso!")
                } else {
                    exibirToast("Ocorreu um erro a criar a conta!")
//                    task.exception
                }
            }
    }

    private fun exibirToast(mensagem: String) {
        // Cria e exibe o Toast
        Toast.makeText(this, mensagem, Toast.LENGTH_SHORT).show()
    }
}