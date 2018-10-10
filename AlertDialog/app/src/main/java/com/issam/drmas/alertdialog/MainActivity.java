package com.issam.drmas.alertdialog;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void RateMeDialog(View view){
        startActivity(new Intent(MainActivity.this, RateMeDialogActivity.class));
    }

    public void NotDismissAlertDialog(View view){
        startActivity(new Intent(MainActivity.this, NotDismissAlertDialogActivity.class));
    }

    public void OneButtonAlertDialog(View view){
        startActivity(new Intent(MainActivity.this, OneButtonAlertDialogActivity.class));
    }
    public void PassingEventAlertDialog(View view){
        startActivity(new Intent(MainActivity.this, PassingEventAlertDialogActivity.class));
    }
}
