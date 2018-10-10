package com.drmas.issam.sharefood;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.tasks.OnCompleteListener;

import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;

import com.google.firebase.auth.FacebookAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import com.google.firebase.firestore.FirebaseFirestore;

public class LoginActivity extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener{

    /// Declaration Edit Text
    private EditText loginEmailText;
    private EditText loginPassText;

    private Button login_btn;
    private TextView txtNowAccount;

    /// Declaration FireBase
    private FirebaseAuth mAuth;
    private FirebaseFirestore firebaseFirestore;
    private ProgressBar progressLogin;


    /// Declaration Login Witj Facebook
    private CallbackManager mCallbackManager;
    private static final String TAG = "tag";

    // Declaration Google SignIn
    private GoogleApiClient googleApiClient;
    private ImageButton buttonSignGoogle;
    public static final int RC_SIGN_IN = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_login );

        loginEmailText = (EditText) findViewById( R.id.login_email );
        loginPassText = (EditText) findViewById( R.id.login_pass );

        login_btn = (Button)findViewById( R.id.login_btn );
        txtNowAccount = (TextView) findViewById( R.id.txtNowAccount);

        mAuth = FirebaseAuth.getInstance();
        firebaseFirestore = FirebaseFirestore.getInstance();


        progressLogin = (ProgressBar)findViewById( R.id.progressLogin );

        login_btn.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();

                String loginEmail = loginEmailText.getText().toString().trim();
                String loginPass = loginPassText.getText().toString().trim();

                // Check form is correct
                if (TextUtils.isEmpty( loginEmail )){
                    loginEmailText.setError( "Please enter email valid" );
                    loginEmailText.requestFocus();
                }
                if (TextUtils.isEmpty( loginPass )){
                    loginPassText.setError( "Please enter password " );
                }

                if (!TextUtils.isEmpty( loginEmail ) && !TextUtils.isEmpty( loginPass )){

                    progressLogin.setVisibility( View.VISIBLE );
                    mAuth.signInWithEmailAndPassword( loginEmail, loginPass ).addOnCompleteListener( new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                                       if (task.isSuccessful()){

                                         //  sendToMainActivity();
                                            checkUser();

                                   } else {

                               String errorMessage = task.getException().getMessage();
                               Toast.makeText( LoginActivity.this, "Try Again"+ errorMessage, Toast.LENGTH_LONG ).show();

                               }


                            progressLogin.setVisibility( View.INVISIBLE);
                        }
                    });
                }
            }
        });

        txtNowAccount.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent = new Intent( LoginActivity.this, RegisterActivity.class );
                startActivity( registerIntent );
            }
        });

        ///// Start Initialize Facebook Login Button //////////////////////////////////////////

        mCallbackManager = CallbackManager.Factory.create();

        LoginButton loginButton = (LoginButton) findViewById( R.id.login_button_facebook );
        loginButton.setReadPermissions( "email", "public_profile" );

        loginButton.registerCallback( mCallbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {

                progressLogin.setVisibility( View.VISIBLE );
                Log.d(TAG, "facebook:onSuccess:" + loginResult);
                handleFacebookAccessToken(loginResult.getAccessToken());
                progressLogin.setVisibility( View.INVISIBLE );

            }

            @Override
            public void onCancel() {
                Log.d( TAG, "facebook:onCancel" );

            }

            @Override
            public void onError(FacebookException error) {
                Log.d( TAG, "facebook:onError", error );
            }

        });
        ///// End Initialize Facebook Login Button /////////////////////////////////////////

        /////// Start Initialize Sign in With Google ////////////////////////////////////////


        GoogleSignInOptions gso = new GoogleSignInOptions.Builder( GoogleSignInOptions.DEFAULT_SIGN_IN )
                .requestEmail()
                .build();

        googleApiClient = new GoogleApiClient.Builder( this )
                .enableAutoManage( this, this )
                .addApi( Auth.GOOGLE_SIGN_IN_API, gso )
                .build();

        buttonSignGoogle = (ImageButton) findViewById( R.id.buttonSignGoogle );
        buttonSignGoogle.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                progressLogin.setVisibility( View.VISIBLE );
                Intent intent = Auth.GoogleSignInApi.getSignInIntent( googleApiClient );
                startActivityForResult( intent, RC_SIGN_IN );
                progressLogin.setVisibility( View.INVISIBLE );

            }
        });

        /////// End Initialize Sign in With Google /////////////////////////////////////////


    } //// End Main

    public void checkUser(){

        final FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();

        if (currentUser.isEmailVerified()){

            sendToMainActivity();

        } else {

           showMessageVerification();
        }

    }

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

            }
        });

        // Click Negative
        alertDlg.setNegativeButton( "Not now", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                finish();
            }
        } );
        alertDlg.create().show();

    }

    private void sendToMainActivity() {

        Intent mainIntent = new Intent( LoginActivity.this, SetupActivity.class );
        startActivity( mainIntent );
    }

    public void ForgotPassword(View view){
        Intent registerIntent = new Intent( LoginActivity.this, ResetPassActivity.class );
        startActivity( registerIntent );
    }

    /////// Start All Fun Login With Facebook ///////////////////////////////

    private void updateUIFacebook(){

        /// Check if user is signed in (non_null) and update UI accordingly.
        FirebaseUser currentUsers = mAuth.getCurrentUser();
        if (currentUsers != null){
            Intent mainIntent = new Intent( LoginActivity.this, MainActivity.class );
            startActivity( mainIntent );
            finish();
        }
    }

    private void handleFacebookAccessToken(AccessToken accessToken) {
        Log.d( TAG, "handleFacebookAccessToken:" + accessToken );

        AuthCredential credential = FacebookAuthProvider.getCredential( accessToken.getToken());
        mAuth.signInWithCredential( credential ).addOnCompleteListener( new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if (task.isSuccessful()){
                    /// Sign in success, update UI with the signed_in user's information
                    Log.d( TAG, "signInWithCredential:success" );
                    FirebaseUser user = mAuth.getCurrentUser();
                    updateUIFacebook();

                } else {
                    // If sign in fails, display a message to the user.
                    Log.w(TAG, "signInWithCredential:failure", task.getException());
                    Toast.makeText(LoginActivity.this, "Authentication failed.",
                            Toast.LENGTH_SHORT).show();
                }
            }
        } );

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult( requestCode, resultCode, data );

        /// Pass the activity result to the facebook SDK
        mCallbackManager.onActivityResult( requestCode, resultCode, data );

        /// Result to login with google
        if (requestCode == RC_SIGN_IN){

            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent( data );
            handeSignInResult(result);
        }


    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }
    /////// End All Fun Login With Facebook ///////////////////////////////

    /////// Start All Fun Login With Google ///////////////////////////////
    private void handeSignInResult(GoogleSignInResult result){

        if (result.isSuccess()){
            Intent mainIntent = new Intent( LoginActivity.this, MainActivity.class );
            startActivity( mainIntent );
        } else{
            Toast.makeText( LoginActivity.this, "Error", Toast.LENGTH_LONG ).show();
        }
    }

    /////// End All Fun Login With Google ////////////////////////////////////



}













