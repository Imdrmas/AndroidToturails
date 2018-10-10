package com.issam.drmas.nadyelhikma;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class View2Activity extends AppCompatActivity {

    private AdView adView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view2);

        WebView webView = findViewById(R.id.webView2);

        Intent data2 = getIntent();
        int page2 = data2.getExtras().getInt("page2");
        page2++;
        webView.loadUrl("file:///android_asset/two/"+page2+".html");

        adView = findViewById(R.id.adViewWebView2);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);

    }
}
