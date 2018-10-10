package com.drmas.issam.mybirthdate;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    EditText txtBDate;
    TextView txtAge;
    Button btnCalac;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        txtBDate = findViewById( R.id.txtYBDate );
        txtAge = findViewById( R.id.txtAge );
        btnCalac = findViewById( R.id.btnCalac );

        try {
            btnCalac.setOnClickListener( new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    SimpleDateFormat sdf = new SimpleDateFormat( "YYYY" );
                    int nowYear = Integer.parseInt( sdf.format( new Date() ) );
                    int birthYear = Integer.parseInt( txtBDate.getText() + "" );
                    int age = nowYear - birthYear;
                    txtAge.setText( "You are " + age + "" + " years" );

                }
            });
        }catch (Exception e){
            Toast.makeText( this, e.getMessage(), Toast.LENGTH_SHORT ).show();
        }
    }
}
