package com.issam.drmas.nadyelhikma;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class View3Activity extends AppCompatActivity {

    private AdView adView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view3);

        WebView webView = findViewById(R.id.webView3);

        Intent data3 = getIntent();
        int page3 = data3.getExtras().getInt("page3");
        page3++;
        webView.loadUrl("file:///android_asset/three/"+page3+".html");

        adView = findViewById(R.id.adViewWebView3);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);

    }
}
