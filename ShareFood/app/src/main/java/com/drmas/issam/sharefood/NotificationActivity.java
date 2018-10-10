package com.drmas.issam.sharefood;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

public class NotificationActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_notification );


    }

    public void homeNotificationIcon(View view){
        Intent mainIntent = new Intent(NotificationActivity.this, MainActivity.class);
        startActivity( mainIntent );
    }

    public void accountNotificationIcon(View view){
        Intent accountIntent = new Intent(NotificationActivity.this, AccountActivity.class);
        startActivity( accountIntent );
    }

}
