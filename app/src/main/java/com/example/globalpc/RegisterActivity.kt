package com.example.globalpc

import android.app.Activity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
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

    /* GET/SET METHOD DECLARIATION*/

    /**
     * Returns the name entered
     * @return - name as a String
     * */
    private fun getName(): String {
        val usernameInput = findViewById<EditText>(R.id.usernameInput)

        return usernameInput.text.toString()
    }

    /**
     * Returns the email entered
     * @return - email as a String
     * */
    private fun getEmail(): String {
        val emailInput = findViewById<EditText>(R.id.emailInput)

        return emailInput.text.toString()
    }

    /**
     * Returns the password entered
     * @return - password as a String
     * */
    private fun getPassword(): String {
        val passwordInput = findViewById<EditText>(R.id.passwordInput)

        return passwordInput.text.toString()
    }

    /**
     * Returns the password entered
     * @return - password as a String
     * */
    private fun getConfirmPassword(): String {
        val passwordInput = findViewById<EditText>(R.id.repeatPasswordInput)

        return passwordInput.text.toString()
    }



    /* METHODS DECLARIATION*/

    /**
     * Create a account in firebase
     * @param email - Email as String
     * @param password - Password as String
     * */
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

    /**
     * Send a Toast notification to mobile screen
     * @param mensagem - notification content as String
     * */
    private fun exibirToast(mensagem: String) {
        // Cria e exibe o Toast
        Toast.makeText(this, mensagem, Toast.LENGTH_SHORT).show()
    }
}