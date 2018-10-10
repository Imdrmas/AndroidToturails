package com.issam.drmas.myhouse;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ResetPassActivity extends AppCompatActivity {

    private EditText passwordEmail;
    private Button resetPassword;
    private FirebaseAuth mAuth;
    private ProgressBar progressResetPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_pass);

        resetPassword = (Button) findViewById( R.id.buttonPasswordReset );
        passwordEmail = (EditText) findViewById( R.id.textEmailAddress);
        mAuth = FirebaseAuth.getInstance();
        progressResetPass = (ProgressBar)findViewById( R.id.progressResetPass);

        resetPassword.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String user_email = passwordEmail.getText().toString().trim();

                if (user_email.equals( "" )){
                    Toast.makeText( ResetPassActivity.this, "Please enter your register email ", Toast.LENGTH_LONG ).show();
                } else {
                    progressResetPass.setVisibility( View.VISIBLE );
                    mAuth.sendPasswordResetEmail( user_email ).addOnCompleteListener( new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {

                            if (task.isSuccessful()){

                                showMessageVerificationPass();


                            } else {
                                Toast.makeText( ResetPassActivity.this, "Error in sending password. Enter email valid", Toast.LENGTH_LONG ).show();
                            }
                        }
                    });

                }
            }
        });
    }

    public void showMessageVerificationPass(){

        AlertDialog.Builder alertDlg = new AlertDialog.Builder( this );
        alertDlg.setTitle( "Sent Message to your email" );
        alertDlg.setMessage( "Please login to enjoy !!" );
        alertDlg.setCancelable( false );

        // Click Positive
        alertDlg.setPositiveButton( "Login", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                startActivity( new Intent( ResetPassActivity.this, LoginActivity.class ));
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

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(ResetPassActivity.this, SetupActivity.class));
    }
    public void btnBackReset(View view){
        startActivity(new Intent(ResetPassActivity.this, SetupActivity.class));
    }
}
