package com.issam.drmas.kotlinmessanger

import android.app.Activity
import android.content.Intent
import android.graphics.drawable.BitmapDrawable
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
}
        /*
        preformRegister()
     //   preformHaveAccount()


    }

    var selectPhotoUri: Uri? = null

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 0 && resultCode == Activity.RESULT_OK && data != null){
            //Check
            Log.d("Main", "Photo was selected")

            selectPhotoUri = data.data

            val  bitmap = MediaStore.Images.Media.getBitmap(contentResolver, selectPhotoUri)
           // val bitmapDrawable = BitmapDrawable(bitmap)
            circleImageView.setImageBitmap(bitmap)
            circleImageView.alpha = 0f
        }
    }

    private fun preformRegister(){
        btnRegister.setOnClickListener {

            val email = emailEditTxt.text.toString()
            val password = passwordEditTxt.text.toString()

            if (email.isEmpty() || password.isEmpty()){
                Toast.makeText(this, "please enter text in email and password", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            Log.d("MainActivity", "Email is: " +email)
            Log.d("MainActivity", "PAssword: " + password)

            //Firebase Auth
            FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener {
                        if (it.isSuccessful) return@addOnCompleteListener

                        Log.d("MainActivity", "Successfully created user with uid: ${it.result.user.uid}")
                        Toast.makeText(this, "Successfully created user: ", Toast.LENGTH_LONG).show()
                        preformHaveAccount()

                      //  uploadImageUser()

                    }.addOnFailureListener {
                        Log.d("Main", "Failed to create user: ${it.message}")
                        Toast.makeText(this, "Failed to create user: ", Toast.LENGTH_LONG).show()
                    }

        }
    }

    private fun uploadImageUser(){
        if (selectPhotoUri == null) return

        val fileName = UUID.randomUUID().toString()
       val ref = FirebaseStorage.getInstance().getReference("/images/$fileName")
        ref.putFile(selectPhotoUri!!)
                .addOnSuccessListener {
                    Log.d("Main", "Successfully upload image: {${it.metadata?.path}}")

                    ref.downloadUrl.addOnSuccessListener {
                        Log.d("Main", "File Loaction: $it")

                        saveUserToData(it.toString())
                    }
                }

    }

    private fun saveUserToData(imgUSuer: String){

        val uid = FirebaseAuth.getInstance().uid
        val ref= FirebaseDatabase.getInstance().getReference("/users/$uid")

        val user = User(uid!!, userNameEditTxt.text.toString(), imgUSuer)
        ref.setValue(user)
                .addOnSuccessListener {
                    Log.d("main", "Finally saved the user to firebase:")
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


     circleImageView.setOnClickListener {
            Log.d("Main", "Try to sho photo selector" )

            val intent = Intent(Intent.ACTION_PICK)
            intent.type = "image/*"
            startActivityForResult(intent, 0)
        }


class User(val uid: String, val username:String, val imgUser:String){

}
        */