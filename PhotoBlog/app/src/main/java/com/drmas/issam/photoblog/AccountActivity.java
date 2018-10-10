package com.drmas.issam.photoblog;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class AccountActivity extends AppCompatActivity {

    private BottomNavigationView mainBtnNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_account );


    } ///// End Main


    public void homeClicked(View view){
        Intent mainIntent = new Intent( AccountActivity.this, MainActivity.class );
        startActivity( mainIntent );
    }
    public void notificationClicked(View view){
        Intent notificationIntent = new Intent( AccountActivity.this, NotificationActivity.class );
        startActivity( notificationIntent );
    }
    public void accountClicked(View view){
        Intent accountIntent = new Intent( AccountActivity.this, AccountActivity.class );
        startActivity( accountIntent );
    }



} ///// Ending
