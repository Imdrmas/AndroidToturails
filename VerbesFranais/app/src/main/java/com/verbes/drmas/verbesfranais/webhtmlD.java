package com.verbes.drmas.verbesfranais;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class webhtmlD extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_webhtml_d );

        WebView webView = findViewById(R.id.webViewd);

        Intent data = getIntent();
        int page = data.getExtras().getInt("page");
        page++;
        webView.loadUrl("file:///android_asset/verbe_d/"+page+".html");


    } // end main

} // enndding
