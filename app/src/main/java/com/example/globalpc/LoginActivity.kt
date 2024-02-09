package com.example.globalpc

import android.app.Activity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LoginActivity : Activity() {
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_activity)

        // Initialize Firebase Auth
        auth = Firebase.auth

        val loginBtn = findViewById<Button>(R.id.loginBtn)
        loginBtn.setOnClickListener {checkSignIn()}
    }

    private fun getEmail(): String {
        val emailInput = findViewById<EditText>(R.id.emailInput)

        return emailInput.text.toString()
    }

    private fun getPassword(): String {
        val passwordInput = findViewById<EditText>(R.id.passwordInput)

        return  passwordInput.text.toString()
    }

    private fun signIn(email: String, password: String) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    exibirToast("Login efetuado!")
                    val user = auth.currentUser
                } else {
                    // If sign in fails, display a message to the user.
                    exibirToast("Não foi possível efetuar login. Verifique as credenciais.")
                }
            }
    }

    private fun checkSignIn(){
        if (getEmail() == ""){
            Toast.makeText(this, "Preencha o campo do email!", Toast.LENGTH_SHORT).show()
        }

        else if(getPassword() == ""){
            Toast.makeText(this, "Preencha o campo da password!", Toast.LENGTH_SHORT).show()
        }

        else{
            signIn(getEmail(), getPassword())
        }
    }

    private fun exibirToast(mensagem: String) {
        // Cria e exibe o Toast
        Toast.makeText(this, mensagem, Toast.LENGTH_SHORT).show()
    }
}

