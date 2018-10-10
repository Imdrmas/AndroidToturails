package com.drmas.issam.sharefood;

import android.app.AlertDialog;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.drmas.issam.socialmedia.LoginActivity;
import com.drmas.issam.socialmedia.R;
import com.drmas.issam.socialmedia.SetupActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class MainActivity extends AppCompatActivity {

    private android.support.v7.widget.Toolbar mainToolbar;

    private FirebaseAuth mAuth;
    private FirebaseFirestore firebaseFirestore;

    private String current_user_id;

    private FloatingActionButton addPostBtn;
    private BottomNavigationView mainBottonNav;

    private HomeFragment homeFragment;
    private NotificationFragment notificationFragment;
    private AccountFragment accountFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );


        mAuth = FirebaseAuth.getInstance();
        firebaseFirestore = FirebaseFirestore.getInstance();

        mainToolbar = findViewById( R.id.main_toolbar);
        setSupportActionBar( mainToolbar );

        mainBottonNav = findViewById( R.id.mainBottomNav );

        // FRAGMENT
        homeFragment = new HomeFragment();
        notificationFragment = new NotificationFragment();
        accountFragment = new AccountFragment();


        replaceFragment( homeFragment );

        mainBottonNav.setOnNavigationItemSelectedListener( new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.iconHomeMain:
                        replaceFragment( homeFragment );
                        return true;

                    case R.id.iconNotificationMain:
                        replaceFragment( notificationFragment );
                        return true;

                    case R.id.iconAccountMain:
                        replaceFragment( accountFragment );
                        return true;

                    default:
                        return false;
                }
            }
        });


        addPostBtn = findViewById( R.id.addPostBtn );
        addPostBtn.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent newPostIntent = new Intent( MainActivity.this, NewPostActivity.class );
                startActivity( newPostIntent );
            }
        });


    } //// End Main

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate( R.menu.main_menu, menu );
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.actionLogoutBtn){
            loginOut();
        }
        else if (id == R.id.actionSeetingsBtn){

            Intent setupIntent = new Intent( MainActivity.this, SetupActivity.class );
            startActivity( setupIntent );
        }
        return super.onOptionsItemSelected( item );
    }

    private void loginOut() {

        mAuth.signOut();
        sendToLogin();
    }

    private void sendToLogin(){

        Intent loginIntent = new Intent( MainActivity.this, LoginActivity.class );
        startActivity( loginIntent );

    }

    @Override
    protected void onStart() {
        super.onStart();

        final FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();

        if (currentUser == null){

            sendToLogin();

        } else {

            current_user_id = mAuth.getCurrentUser().getUid();
            firebaseFirestore.collection( "Users" ).document(current_user_id).get().addOnCompleteListener( new OnCompleteListener<DocumentSnapshot>() {
                @Override
                public void onComplete(@NonNull Task<DocumentSnapshot> task) {

                    if (task.isSuccessful()){

                        if (!task.getResult().exists()){



                        }
                    } else {
                        String errorMessage = task.getException().getMessage();
                        Toast.makeText( MainActivity.this, "Error: "+errorMessage, Toast.LENGTH_LONG ).show();
                    }
                }
            });
        }
    }

    public void replaceFragment(android.support.v4.app.Fragment fragment){

        android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace( R.id.mainContainer, fragment );
        fragmentTransaction.commit();

    }



}
