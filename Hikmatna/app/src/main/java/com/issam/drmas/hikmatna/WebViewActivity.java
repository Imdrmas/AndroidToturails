package com.issam.drmas.hikmatna;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.webkit.WebView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class WebViewActivity extends AppCompatActivity {

          private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        mAdView = (AdView) findViewById(R.id.adViewWebView);
        AdRequest adRequest = new AdRequest.Builder()
                .build();
        mAdView.loadAd(adRequest);

        WebView webView = findViewById(R.id.webView);

        Intent data = getIntent();
        int page = data.getExtras().getInt("page");
        page++;
        webView.loadUrl("file:///android_asset/hikam/"+page+".html");
    }

    @Override
    protected void onPause() {
        if(mAdView != null){
            mAdView.pause();
        }
        super.onPause();
    }

    @Override
    protected void onResume() {
        if (mAdView != null){
            mAdView.resume();
        }
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        if (mAdView != null){
            mAdView.destroy();
        }
        super.onDestroy();
    }
}
