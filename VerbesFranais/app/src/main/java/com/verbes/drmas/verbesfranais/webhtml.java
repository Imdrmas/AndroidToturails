package com.verbes.drmas.verbesfranais;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

public class webhtml extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_webhtml );


        WebView webView = findViewById(R.id.webView);

        Intent data = getIntent();
        int page = data.getExtras().getInt("page");
        page++;
        webView.loadUrl("file:///android_asset/verbe_a/"+page+".html");




    } // end Main




} // the endind



