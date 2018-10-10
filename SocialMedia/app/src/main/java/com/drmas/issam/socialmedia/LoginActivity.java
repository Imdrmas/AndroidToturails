package com.drmas.issam.socialmedia;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.speech.tts.TextToSpeechService;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.facebook.FacebookSdk;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FacebookAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class LoginActivity extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener {

    /// Declaration EditText
    private EditText loginEmail;
    private EditText loginPass;
    private String email, pass;

    /// Declaration FireDataBase
    private FirebaseAuth mAuth;
    private DatabaseReference mDatabase;
    private int progressState = 0;

    /// Declaration vars Save Pass and Email
    private CheckBox saveLoginCheckBox;
    private SharedPreferences loginPreferences;
    private SharedPreferences.Editor loginPrefsEditor;
    private Boolean saveLogin;
    private Button loginButton;

    // Declaration Login With Facebook
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

        /// initialise EditText
        loginEmail = (EditText)findViewById( R.id.loginEmail );
        loginPass = (EditText)findViewById( R.id.loginPass );
        saveLoginCheckBox = (CheckBox) findViewById( R.id.savelogincheckbox );
        loginButton = (Button) findViewById( R.id.loginButton );

        /// initialise to Save Pass and Email
        loginPreferences = getSharedPreferences("loginPrefs", MODE_PRIVATE );
        loginPrefsEditor = loginPreferences.edit();
        saveLogin = loginPreferences.getBoolean( "saveLogin", false );

        /// initialise FireDataBase
        mAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference().child("Users");

        ///// Start Initialize Facebook Login Button //////////////////////////////////////////
        mCallbackManager = CallbackManager.Factory.create();

        LoginButton loginButton = (LoginButton)findViewById( R.id.login_button_facebook);
        loginButton.setReadPermissions("email", "public_profile");
        loginButton.registerCallback(mCallbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {

                 showProgressDialogLogin();
                Log.d(TAG , "facebook:onSuccess:" + loginResult);
                handleFacebookAccessToken(loginResult.getAccessToken());
            }

            @Override
            public void onCancel() {
                Log.d(TAG , "facebook:onCancel");
                // ...
            }

            @Override
            public void onError(FacebookException error) {
                Log.d(TAG , "facebook:onError", error);
                // ...
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

                showProgressDialogLogin();
                Intent intent = Auth.GoogleSignInApi.getSignInIntent( googleApiClient );
                startActivityForResult( intent, RC_SIGN_IN );
            }
        } );

        /////// End Initialize Sign in With Google /////////////////////////////////////////




    } //******** End Main **********************




    //*****************************************************
    // Fun Login Form
   public void loginButtonClicked(View view){

        // Get value from user
        final String email = loginEmail.getText().toString().trim();
        final String pass = loginPass.getText().toString().trim();

        // Check form is correct
        if (TextUtils.isEmpty( email )){
            loginEmail.setError( "Please enter email valid" );
            loginEmail.requestFocus();
        }
        if (TextUtils.isEmpty( pass )){
            loginPass.setError( "Please enter password " );
        }

        if (saveLogin == true){
            loginEmail.setText( loginPreferences.getString( "email", "" ));
            loginPass.setText( loginPreferences.getString( "pass", "" ));
            saveLoginCheckBox.setChecked( true );
        }

         // Check info sent successful
        if (!TextUtils.isEmpty( email ) && !TextUtils.isEmpty( pass )){

            mAuth.signInWithEmailAndPassword( email, pass ).addOnCompleteListener( new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {

                    if (task.isSuccessful()){

                        // show alert Msg
                        showProgressDialogLogin();
                        checkUserExists();

                    }  else if (!task.isSuccessful()){
                        Toast.makeText( LoginActivity.this, "Please enter email and password valid", Toast.LENGTH_LONG ).show();
                    }
                }
            });
        }
    }

    // Fun Save Email and Pass
   public void onClick(View v){

        if (v == loginButton){

            InputMethodManager inputMethodManager = (InputMethodManager)getSystemService( Context.INPUT_METHOD_SERVICE );
            inputMethodManager.hideSoftInputFromWindow( loginEmail.getWindowToken(), 0 );

            email = loginEmail.getText().toString();
            pass = loginPass.getText().toString();

            if (saveLoginCheckBox.isChecked()){
                loginPrefsEditor.putBoolean( "saveLogin", true );
                loginPrefsEditor.putString( "email", email );
                loginPrefsEditor.putString( "pass", pass );
                loginPrefsEditor.commit();
            } else {
                loginPrefsEditor.clear();
                loginPrefsEditor.commit();
            }
            goToHomeActivity();

        }
    }

    // Fun Check User
    public void checkUserExists(){

        // Get user ID to check it
        final String user_id = mAuth.getCurrentUser().getUid();
        final FirebaseUser user = mAuth.getCurrentUser();

        mDatabase.addValueEventListener( new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
             if (dataSnapshot.hasChild( user_id )){

                 // Msg verify Email
                 showMessageVerification();

                 // Check email is verified from user
                 if (user.isEmailVerified()){

                     showProgressDialogLogin(); // Show dialog
                     Intent homeIntent = new Intent(LoginActivity.this, SetupActivity.class  );
                     startActivity( homeIntent );
                 }
               }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
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

               // Toast.makeText( LoginActivity.this, "Please go to your email", Toast.LENGTH_LONG ).show();
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

    // Fun Show Progress
    public void showProgressDialogLogin(){

        final ProgressDialog pDialog = new ProgressDialog( this );
        pDialog.setMessage("Loading...");
        pDialog.setCancelable(false);

        pDialog.setProgressStyle( ProgressDialog.STYLE_HORIZONTAL );
        pDialog.setProgress( 0 ); // Start dialog
        pDialog.setMax(100); // end Dialog

        pDialog.show();

        new Thread( new Runnable() {
            @Override
            public void run() {
                while (progressState < 100){
                    progressState += 10; // add 10s

                    try {
                        Thread.sleep( 1000 ); // wait 10s
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    pDialog.setProgress( progressState );
                }
                if (progressState >= 100){ // cancel dialog
                    pDialog.dismiss();
                }
            }
        }).start();
    }

    // Fun Go Back
    public void onBackPressed(){
        createDialog();
    }

    // Fun Dialog to go back
    private void createDialog() {

        AlertDialog.Builder alerDlg = new AlertDialog.Builder( this );
        alerDlg.setMessage( "Are you sure want to exit ?" );
        alerDlg.setCancelable( false );

        // positive click
        alerDlg.setPositiveButton( "Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                LoginActivity.super.onBackPressed();
                // rest in main page
            }
        });
        // negative click
        alerDlg.setNegativeButton( "No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            // back to last page
            }
        });
        alerDlg.create().show();
    }

    // Fun Go to Home activity
    private void goToHomeActivity(){
        startActivity( new Intent( LoginActivity.this, HomeActivity.class ));
        LoginActivity.this.finish();
    }

    // Fun Go To Rest Password
    public void ForgotPassword(View view){
        Intent PasswordIntent = new Intent( LoginActivity.this, PasswordActivity.class );
        startActivity( PasswordIntent );

    }

    public void RegisterColickedActivity(View view){
        Intent RegisterIntent = new Intent( LoginActivity.this, RegisterActivity.class );
        startActivity(RegisterIntent);
    }

     /////// Start All Fun Login With Facebook ///////////////////////////////

     private void updateUIFacebook() {

         // Check if user is signed in (non-null) and update UI accordingly.
         FirebaseUser currentUsers = mAuth.getCurrentUser();
         if(currentUsers != null){
        Toast.makeText( LoginActivity.this, "You are loggied in", Toast.LENGTH_LONG ).show();
        Intent homeIntent = new Intent(LoginActivity.this, HomeActivity.class);
        startActivity( homeIntent );
    }
     }
     private void handleFacebookAccessToken(AccessToken token) {
        Log.d(TAG, "handleFacebookAccessToken:" + token);

        AuthCredential credential = FacebookAuthProvider.getCredential(token.getToken());
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {

                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithCredential:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            updateUIFacebook();
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithCredential:failure", task.getException());
                            Toast.makeText(LoginActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                           // updateUIFacebook();
                        }

                        // ...
                    }
                });
    }

     @Override
     public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

     @Override
     protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult( requestCode, resultCode, data );

         // Pass the activity result back to the Facebook SDK
         mCallbackManager.onActivityResult( requestCode, resultCode, data );

      // Result To login with google
         if (requestCode == RC_SIGN_IN){

             GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent( data );
             handeSignInResult(result);
         }
    }

    /////// End All Fun Login With Facebook ///////////////////////////////



    /////// Start All Fun Login With Google ///////////////////////////////

    private void handeSignInResult(GoogleSignInResult result) {

        if (result.isSuccess()){

            goMainActivity();
     Toast.makeText( LoginActivity.this, "Login successful", Toast.LENGTH_LONG ).show();

        } else {
            Toast.makeText( LoginActivity.this, "Error", Toast.LENGTH_LONG ).show();
        }
    }

    private void goMainActivity() {

        Intent homeIntent = new Intent( LoginActivity.this, HomeActivity.class );
        homeIntent.addFlags( Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK );
        startActivity( homeIntent );
    }

    /////// End All Fun Login With Google ////////////////////////////////////




      } /// Ending Class *****************************
