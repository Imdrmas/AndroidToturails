package com.issam.drmas.spinnerexample;

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

    public void textSpinner(View view){
      startActivity(new Intent(MainActivity.this, TextSpinnerActivity.class));
    }
    public void populateSpinner(View view){
        startActivity(new Intent(MainActivity.this, PopulateSpinnerActivity.class));
    }

    public void customSpinner(View view){
        startActivity(new Intent(MainActivity.this, CustomSpinnerActivity.class));
    }
}
