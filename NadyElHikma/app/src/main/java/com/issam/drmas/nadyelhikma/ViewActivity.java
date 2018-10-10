package com.issam.drmas.nadyelhikma;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class ViewActivity extends AppCompatActivity {

    private AdView adView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        WebView webView = findViewById(R.id.webView);

        Intent data = getIntent();
        int page = data.getExtras().getInt("page");
            page++;
        webView.loadUrl("file:///android_asset/one/"+page+".html");

        adView = findViewById(R.id.adViewWebView);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);

    }
}
