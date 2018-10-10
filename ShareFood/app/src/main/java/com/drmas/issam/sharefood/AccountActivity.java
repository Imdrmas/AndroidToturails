package com.drmas.issam.sharefood;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class AccountActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_account );
    }

    public void homeAccountIcon(View view){
        Intent mainIntent = new Intent( AccountActivity.this, MainActivity.class );
        startActivity( mainIntent );
    }
    public void notificationAccountIcon(View view){
        Intent notificationIntent = new Intent( AccountActivity.this, NotificationActivity.class );
        startActivity( notificationIntent );
    }

}
