package com.drmas.issam.sharefood;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FacebookAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class RegisterActivity extends AppCompatActivity {

    /// Declarations Edit Text
    private EditText reg_email_field, reg_pass_field, reg_confirm_pass_filed;

    private Button reg_btn;
    private ProgressBar reg_progressBar;

    /// Declaration FireBase
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_register );

        /// initialise Edit Text
        reg_email_field = (EditText) findViewById( R.id.registerTxtEmail );
        reg_pass_field = (EditText) findViewById( R.id.registerTxtPass );
        reg_confirm_pass_filed = (EditText) findViewById( R.id.registerConfirmPass );

        /// initialise Firebase
        reg_btn = (Button) findViewById( R.id.registerBtn );
        reg_progressBar = (ProgressBar) findViewById( R.id.reg_progressBar );

        mAuth = FirebaseAuth.getInstance();


        /// Fun Register User Info
        reg_btn.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /// Get Values From User Email Pass and confirm Pass
                String email = reg_email_field.getText().toString();
                String pass = reg_pass_field.getText().toString();
                String confirmPass = reg_confirm_pass_filed.getText().toString();

                /// Condition the form there not error
                if (!Patterns.EMAIL_ADDRESS.matcher( email ).matches()){
                    reg_email_field.setError( "Please enter email valid" );
                    reg_email_field.requestFocus();
                }
                if (reg_pass_field.length() < 6 || reg_pass_field.length() > 12){
                    reg_pass_field.setError( "Password should be between 6 and 10 Characters" );
                }

                /// Check there no error to send data
                if (!TextUtils.isEmpty( email ) && !TextUtils.isEmpty( pass ) && !TextUtils.isEmpty( confirmPass )){
                    if (pass.equals( confirmPass )){

                        /// Create user with email and pass
                        reg_progressBar.setVisibility( View.VISIBLE );
                        mAuth.createUserWithEmailAndPassword( email, pass ).addOnCompleteListener( new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {

                                if (task.isSuccessful()){

                                    sendEmailVerification();
                                    showMessageVerification();

                                } else {

                                    String errorMessage = task.getException().getMessage();
                                    Toast.makeText( RegisterActivity.this, "Error "+ errorMessage, Toast.LENGTH_LONG ).show();
                                }
                                reg_progressBar.setVisibility( View.INVISIBLE );
                            }
                        });
                    } else {
                        reg_confirm_pass_filed.setError( "Confirm Password and Passowrd Filed not Match" );
                    }

                }

            }
        });


    } //// end Main

    // Fun Msg To verify Email
    public void showMessageVerification(){

        AlertDialog.Builder alertDlg = new AlertDialog.Builder( this );
        alertDlg.setTitle( "Sent Message to your email" );
        alertDlg.setMessage( "Please verification your email" );
        alertDlg.setCancelable( false );

        // Click Positive
        alertDlg.setPositiveButton( "Verification", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                Intent setupIntent = new Intent( RegisterActivity.this, LoginActivity.class );
                startActivity( setupIntent );
                finish();
            }
        });

        // Click Negative
        alertDlg.setNegativeButton( "Not now", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });

        alertDlg.create().show();

    }

    public void LoginColickedActivitty(View view){
        Intent loginIntent = new Intent( RegisterActivity.this, LoginActivity.class );
        startActivity( loginIntent );
    }

    ////// Fun Verification Email
    public void sendEmailVerification(){

        // Get user current to send verify email
        final FirebaseUser user = mAuth.getCurrentUser();
        user.sendEmailVerification().addOnCompleteListener( this, new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                findViewById( R.id.registerBtn).setEnabled( true );

                if (task.isSuccessful()){
                  //  messageEmailConfirmation();
                //Toast.makeText(RegisterActivity.this, "Verification email sent to "+user.getEmail(), Toast.LENGTH_LONG ).show();

                } else {
                    // Log.e( Tag, "sentEmailVerication", task.getException());
                    Toast.makeText( RegisterActivity.this, "ailed to sent verification email", Toast.LENGTH_LONG ).show();

                }

            }
        });

    }




}//// Ending
