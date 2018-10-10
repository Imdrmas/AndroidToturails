package com.drmas.issam.photoblog;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {

    private EditText loginEmailText;
    private EditText loginPassText;

    private Button login_btn;
    private Button go_reg_btn;

    private FirebaseAuth mAuth;
    private ProgressBar progressLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_login );

        loginEmailText = (EditText) findViewById( R.id.login_email );
        loginPassText = (EditText) findViewById( R.id.login_pass );

        login_btn = (Button)findViewById( R.id.login_btn );
        go_reg_btn = (Button)findViewById( R.id.login_reg_btn);


        mAuth = FirebaseAuth.getInstance();
        progressLogin = (ProgressBar)findViewById( R.id.progressLogin );


        login_btn.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String loginEmail = loginEmailText.getText().toString().trim();
                String loginPass = loginPassText.getText().toString().trim();

                if (!TextUtils.isEmpty( loginEmail ) && !TextUtils.isEmpty( loginPass )){

                    progressLogin.setVisibility( View.VISIBLE );
                    mAuth.signInWithEmailAndPassword( loginEmail, loginPass ).addOnCompleteListener( new OnCompleteListener<AuthResult>() {

                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            if (task.isSuccessful()){

                                sendToMainActivity();
                                Toast.makeText( LoginActivity.this, "Login ", Toast.LENGTH_LONG ).show();

                                finish();

                            } else {
                                String errorMessage = task.getException().getMessage();
                                Toast.makeText( LoginActivity.this, "Error "+ errorMessage, Toast.LENGTH_LONG ).show();
                            }
                            progressLogin.setVisibility( View.INVISIBLE );
                        }
                    });
                }

            }
        });

        go_reg_btn.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent = new Intent( LoginActivity.this, RegisterActivity.class );
                startActivity( registerIntent );
            }
        } );


    }


    private void sendToMainActivity() {
        Intent intent = new Intent( LoginActivity.this, MainActivity.class );
        startActivity( intent );
        finish();
    }


}
