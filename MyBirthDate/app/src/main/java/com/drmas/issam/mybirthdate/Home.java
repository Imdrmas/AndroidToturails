package com.drmas.issam.mybirthdate;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_home );
        final Intent intent = new Intent( this, MainActivity.class );
        final Intent intent2 = new Intent( this, Main2Activity.class );

        GotoActivity( R.id.btnBitrh, MainActivity.class);
        GotoActivity( R.id.btncalulator, Main2Activity.class);
        GotoActivity( R.id.btnEditor, Editor.class);
        GotoActivity( R.id.btnCall, MyCall.class);


       /* btn.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity( intent );
            }
        });

        btn2.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity( intent2 );
            }
        } );
        */


    }//end main

    protected void GotoActivity(int btnId, final Class ActToOpen){
        Button btn2 = (Button)findViewById(btnId);
        btn2.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity( new Intent( getBaseContext(), ActToOpen ));
            }
        } );
    }
}
