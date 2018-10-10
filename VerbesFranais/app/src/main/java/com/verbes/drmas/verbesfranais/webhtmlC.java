package com.verbes.drmas.verbesfranais;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class webhtmlC extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_webhtml_c );


        WebView webViewc = findViewById(R.id.webViewC);

        Intent datac = getIntent();
        int pagec = datac.getExtras().getInt("pagec");
        pagec++;
        webViewc.loadUrl("file:///android_asset/verbe_c/"+pagec+".html");

    }
}
