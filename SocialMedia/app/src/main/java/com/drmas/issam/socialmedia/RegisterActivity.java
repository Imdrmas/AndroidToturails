package com.drmas.issam.socialmedia;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.nfc.Tag;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FacebookAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.BufferedReader;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.facebook.FacebookSdk;


public class RegisterActivity extends AppCompatActivity  {

    // Declaration EditText
    private EditText nameField, emailField, passField;
    private int progressState = 0;

    // Declaration FireDatabase
    private FirebaseAuth mAuth;
    private DatabaseReference mDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_register );

        // initialise EditText
        nameField = (EditText)findViewById( R.id.nameField );
        emailField = (EditText)findViewById( R.id.emailField);
        passField = (EditText)findViewById( R.id.passField );

        // initialise FireDatabase
        mAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference().child("Users");


    }/// End Main



     //////  Fun Register User Info
    public void registerColicked(View view) {

        // Get value from user name, pass and email
        final String name = nameField.getText().toString().trim();
        final String email = emailField.getText().toString().trim();
        String pass = passField.getText().toString().trim();


        // condition the form is correct
        if (nameField.length() < 4 || nameField.length() > 10) {
            nameField.setError( "Name should be between 4 and 10 characters" );
            nameField.requestFocus();
        }
        if (passField.length() < 6 || passField.length() > 10) {
            passField.setError( "Password should be between 6 and 10 characters" );
        }
        if (!Patterns.EMAIL_ADDRESS.matcher( email ).matches()){
            emailField.setError( "Please enter email valid" );
        }

              /// Check there no error to send data
            if (!TextUtils.isEmpty( name ) && !TextUtils.isEmpty( email ) && !TextUtils.isEmpty( pass )) {

                 // Create user with email and pass
                mAuth.createUserWithEmailAndPassword( email, pass ).addOnCompleteListener( new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        // check data is successful
                        if (task.isSuccessful()) {

                            // fun show dialog and Verification email
                            showProgressDialog();
                            sendEmailVerification();

                            //add Username to main data
                            String user_id = mAuth.getCurrentUser().getUid();
                            DatabaseReference current_user_db = mDatabase.child( user_id );
                            current_user_db.child( "Name" ).setValue( name );
                            current_user_db.child( "Image" ).setValue( "default" );


                            // check there is an error
                        } else if (!task.isSuccessful()){
                           Toast.makeText(RegisterActivity.this, "Please verification email is exists ", Toast.LENGTH_LONG ).show();
                        }
                    }
                });
            }

        }

    /////  Fun Go To Activity Login
    public void LoginColickedActivitty(View view){
        Intent loginIntent = new Intent( RegisterActivity.this, LoginActivity.class );
        startActivity( loginIntent );

    }

    ////// Fun Progress
    public void showProgressDialog(){

        /// Start Dialog
        final ProgressDialog pDialog = new ProgressDialog( this );
        pDialog.setMessage("Loading...");
        pDialog.setCancelable(false);

        pDialog.setProgressStyle( ProgressDialog.STYLE_HORIZONTAL ); // Style
        pDialog.setProgress( 0 ); // Start Time
        pDialog.setMax(100); // End Time

        pDialog.show();

        // Check Progress State
        new Thread( new Runnable() {
            @Override
            public void run() {
                while (progressState < 100){
                    progressState += 10;

                    try {
                        Thread.sleep( 1000 ); // Sleep 10 Min
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    pDialog.setProgress( progressState );
                }
                if (progressState >= 100){ // Cancel Dialog
                    pDialog.dismiss();
                }
            }
        }).start();
    }

    ////// Fun Confirmation Msg
    public void messageEmailConfirmation(){

        // Alert Conf
        AlertDialog.Builder alertDlg = new AlertDialog.Builder( this );
        alertDlg.setTitle( "Sent Message to your email" ); // Title
        alertDlg.setMessage( "Please verification your email" ); // Message
        alertDlg.setCancelable( false );

        /// Clock Positive
        alertDlg.setPositiveButton( "verify", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
               // RegisterActivity.super.onBackPressed();

                Intent homeIntent = new Intent(RegisterActivity.this, LoginActivity.class  );
                startActivity( homeIntent );

            }
        });
        /// Click Negative
        alertDlg.setNegativeButton( "Not now", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
               // RegisterActivity.super.onBackPressed();
                finish();

            }
        } );
        alertDlg.create().show(); /// Show Alert
    }

    ////// Fun Verification Email
    public void sendEmailVerification(){

        // Get user current to send verify email
        final FirebaseUser user = mAuth.getCurrentUser();
        user.sendEmailVerification().addOnCompleteListener( this, new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                findViewById( R.id.emailField ).setEnabled( true );

                if (task.isSuccessful()){
                    messageEmailConfirmation();
                  //  Toast.makeText(RegisterActivity.this, "Verification email sent to "+user.getEmail(), Toast.LENGTH_LONG ).show();

                } else {
                   // Log.e( Tag, "sentEmailVerication", task.getException());
                    Toast.makeText( RegisterActivity.this, "ailed to sent verification email", Toast.LENGTH_LONG ).show();

                }

            }
        });

    }





}////Ending
