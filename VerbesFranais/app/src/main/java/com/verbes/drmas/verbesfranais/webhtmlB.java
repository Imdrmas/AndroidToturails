package com.verbes.drmas.verbesfranais;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class webhtmlB extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_webhtml_b );

        WebView webViewb = findViewById(R.id.webViewB);

        Intent datab = getIntent();
        int pageb = datab.getExtras().getInt("pageB");
        pageb++;
        webViewb.loadUrl("file:///android_asset/verbe_b/"+pageb+".html");
    }
}
