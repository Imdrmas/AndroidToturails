package com.verbes.drmas.verbesfranais;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class Grammar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_grammar );

        WebView webView = (WebView) findViewById(R.id.webView);
        webView.loadUrl("file:///android_asset/grammar.html");
    }
}
