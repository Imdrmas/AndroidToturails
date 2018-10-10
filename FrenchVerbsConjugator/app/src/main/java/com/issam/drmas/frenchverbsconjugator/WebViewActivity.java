package com.issam.drmas.frenchverbsconjugator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class WebViewActivity extends AppCompatActivity {

    private AdView adView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        WebView webView = findViewById(R.id.webView);

        Bundle intentHistory = getIntent().getExtras();
        String value = intentHistory.getString("value");

         webView.loadUrl("file:///android_asset/"+value+".html");

        adView = findViewById(R.id.adViewWebView);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);
    }

    @Override
    public void onBackPressed() {

        if (getFragmentManager().getBackStackEntryCount() >1){
            getFragmentManager().popBackStack();
            finish();
        }
        else {
            super.onBackPressed();
        }

    }

}
