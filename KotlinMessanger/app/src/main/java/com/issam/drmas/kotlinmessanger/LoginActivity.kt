package com.issam.drmas.kotlinmessanger

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btnLogin.setOnClickListener {

            val email = emailLogin.text.toString()
            val password = passwordLogin.text.toString()

            FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)
                    //.addOnCompleteListener {  }
        }

        backToRegiser.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
