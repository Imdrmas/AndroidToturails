package com.issam.drmas.myapplication;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

   Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        btn = (Button)findViewById( R.id.btn );

        btn.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMessage("Your Welcome");

            }
        });
       }

    protected void showMessage(String message){
        Toast t = Toast.makeText( this, message, Toast.LENGTH_SHORT );
        t.show();

    }





}
