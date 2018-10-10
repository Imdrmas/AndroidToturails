package com.issam.drmas.myhouse;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SetupActivity extends AppCompatActivity {

    FirebaseAuth firebaseAuth;
    private ProgressBar progressSignOut;
    private FirebaseAuth.AuthStateListener authStateListener;
    private FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup);

        firebaseAuth = FirebaseAuth.getInstance();
        user = firebaseAuth.getCurrentUser();

        progressSignOut = findViewById(R.id.progressSignOut);
        progressSignOut.setVisibility(View.GONE);

    }

    public void btnMainPage(View view){
        startActivity(new Intent(SetupActivity.this, Main2Activity.class));
    }
    public void btnProfile(View view){
        startActivity(new Intent(SetupActivity.this, MainActivity.class));
    }
    public void btnAddTask(View view){
        startActivity(new Intent(SetupActivity.this, AddTask.class));
    }

    public void signOut(View view){

        progressSignOut.setVisibility(View.VISIBLE);
        FirebaseAuth.getInstance().signOut();
        sendToLogin();
        finish();
    }

    @Override
    public void onBackPressed() {
       // super.onBackPressed();
       // finish();
    }

    private void sendToLogin() {

        GoogleSignInClient mGoogleSignInClient ;
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();
        mGoogleSignInClient = GoogleSignIn.getClient(getBaseContext(), gso);
        mGoogleSignInClient.signOut().addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                FirebaseAuth.getInstance().signOut(); //signout firebase
                Toast.makeText(getApplicationContext(), "Signed Out", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                finish();
            }
        });

    }


}
