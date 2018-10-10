package com.drmas.issam.photoblog;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class RegisterActivity extends AppCompatActivity {

    private EditText reg_email_field, reg_pass_field, reg_cofirm_pass_filed;
    private Button reg_btn, reg_login_btn;
    private ProgressBar reg_progressBar;

    private FirebaseAuth mAuth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_register );

        reg_email_field = (EditText) findViewById( R.id.registerTxtEmail );
        reg_pass_field = (EditText) findViewById( R.id.registerTxtPass );
        reg_cofirm_pass_filed = (EditText) findViewById( R.id.registerConfirmPass );
        reg_btn = (Button) findViewById( R.id.registerBtn );
        reg_login_btn = (Button)findViewById( R.id.goToLoginActivityBtn );
        reg_progressBar = (ProgressBar) findViewById( R.id.reg_Progress );

        mAuth = FirebaseAuth.getInstance();

        reg_login_btn.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        } );

       reg_btn.setOnClickListener( new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               String email = reg_email_field.getText().toString();
               String pass = reg_pass_field.getText().toString();
               String cofirmPass = reg_cofirm_pass_filed.getText().toString();

               if (!TextUtils.isEmpty( email ) && !TextUtils.isEmpty( pass ) && !TextUtils.isEmpty( cofirmPass )){
                   if (pass.equals( cofirmPass )){

                       reg_progressBar.setVisibility( View.VISIBLE );
                       mAuth.createUserWithEmailAndPassword( email, pass ).addOnCompleteListener( new OnCompleteListener<AuthResult>() {
                           @Override
                           public void onComplete(@NonNull Task<AuthResult> task) {

                               if (task.isSuccessful()){

                                   Intent setupIntent = new Intent( RegisterActivity.this, SetupActivity.class );
                                   startActivity( setupIntent );
                                   finish();

                               } else {
                                   String errorMessage = task.getException().getMessage();
                                   Toast.makeText( RegisterActivity.this, "Error" +errorMessage, Toast.LENGTH_LONG ).show();
                               }
                           }
                       });

                   } else {
                       Toast.makeText( RegisterActivity.this, "Confirm Password and passowrd Filed not Match ", Toast.LENGTH_LONG ).show();
                   }
                   reg_progressBar.setVisibility( View.INVISIBLE );
               }
           }
       });

    }


}
