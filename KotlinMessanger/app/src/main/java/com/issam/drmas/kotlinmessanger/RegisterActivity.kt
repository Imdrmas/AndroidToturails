package com.issam.drmas.kotlinmessanger

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {

    private var mAuth: FirebaseAuth? = null
    var email: String? = null
    var password: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        mAuth = FirebaseAuth.getInstance()
        preformHaveAccount()

       btnRegister.setOnClickListener {

           if (email!!.isEmpty() && password!!.isEmpty()){
               Toast.makeText(this, "Please Enter Password And Email: ", Toast.LENGTH_LONG).show()
           }

           email = emailEditTxt.text.toString()
           password = passwordEditTxt.text.toString()
       }


    }


    private fun preformHaveAccount(){
        haveAnAccount.setOnClickListener {
            Log.d("MainActivity", "try to show login activity")

            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }




}
