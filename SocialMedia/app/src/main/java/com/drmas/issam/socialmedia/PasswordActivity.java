package com.drmas.issam.socialmedia;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class PasswordActivity extends AppCompatActivity {

    private EditText passwordEmail;
    private Button resetPassword;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_password );

        resetPassword = (Button) findViewById( R.id.buttonPasswordReset );
        passwordEmail = (EditText) findViewById( R.id.textEmailAddress);
        mAuth = FirebaseAuth.getInstance();

        resetPassword.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user_email = passwordEmail.getText().toString().trim();

                if (user_email.equals( "" )){
                    Toast.makeText( PasswordActivity.this, "Please enter your register email ", Toast.LENGTH_LONG ).show();
                } else {

                    mAuth.sendPasswordResetEmail( user_email ).addOnCompleteListener( new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {

                            if (task.isSuccessful()){

                                Toast.makeText( PasswordActivity.this, "Password reset email sent!", Toast.LENGTH_LONG ).show();
                                finish();
                                startActivity( new Intent( PasswordActivity.this, LoginActivity.class ));

                            } else {
                                Toast.makeText( PasswordActivity.this, "Error in sending password email", Toast.LENGTH_LONG ).show();
                            }
                        }
                    });
                }
            }
        });
    }
}
