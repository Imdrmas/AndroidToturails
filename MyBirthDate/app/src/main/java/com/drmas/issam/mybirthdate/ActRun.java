package com.drmas.issam.mybirthdate;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;

public class ActRun extends AppCompatActivity {

    WebView myWeb;
    Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_act_run );

        myWeb = (WebView)findViewById( R.id.myWeb);
        btnBack = (Button)findViewById( R.id.btnBack);

        myWeb.getSettings().setJavaScriptEnabled( true );
        myWeb.loadData( MyVar.strHTML, "text/html; charset=utf-8", null );
        btnBack.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        } );
    }
}
