package com.drmas.issam.quizzfrancais;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

public class MainActivity extends AppCompatActivity {

    android.support.v7.widget.Toolbar mtoolbar;

    private final static int FADE_DURATION = 1000;
    View view;

    private InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        mtoolbar = findViewById( R.id.mToolbar );
        setSupportActionBar( mtoolbar );
        setTitle( getString( R.string.app_name ));

        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-7401879888732563/5534531001");

        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                requestNewInterstitial();

                Intent intent = new Intent( MainActivity.this, HeightScore.class );
                startActivity( intent );
            }
        });

        requestNewInterstitial();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater findMenuItems = getMenuInflater();
        findMenuItems.inflate(R.menu.button_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.shareItem:
                String txtShare = this.getString( R.string.app_name );
                String shareLink = "https://play.google.com/store/apps/details?id=com.drmas.issam.quizzfrancais";

                Intent share = new Intent(Intent.ACTION_SEND);
                share.setType("text/plain");

                share.putExtra(Intent.EXTRA_TEXT,txtShare + "\n" + shareLink);
                startActivity(share);
                break;

            case R.id.TopScoreItem:

                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();

                } else {
                    Intent intent = new Intent( MainActivity.this, HeightScore.class );
                    startActivity( intent );
                }
                break;

            case R.id.logoutItem:
                Intent intentAd = new Intent( MainActivity.this, AdsActivity.class );
                startActivity( intentAd );
                break;

        }
        return super.onOptionsItemSelected(item);
    }

    private void requestNewInterstitial() {
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice("SEE_YOUR_LOGCAT_TO_GET_YOUR_DEVICE_ID")
                .build();

        mInterstitialAd.loadAd(adRequest);
    }

    public void religionClicked(View view){

        Intent intent = new Intent( MainActivity.this, ReligionActivity.class );
        startActivity( intent );
    }

    public void historyClicked(View view){

        Intent intent = new Intent( MainActivity.this, HistoireActivity.class );
        startActivity( intent );
    }

    public void capitalClicked(View view){

        Intent intent = new Intent( MainActivity.this, CapitalActivity.class );
        startActivity( intent );
    }

    public void geographicClicked(View view){
       Intent intent = new Intent( MainActivity.this, GeographicActivity.class );
       startActivity( intent );
    }

    public void technologyClicked(View view){

        Intent intent = new Intent( MainActivity.this, TelevisionActivity.class );
        startActivity( intent );
    }

    public void sciencesClicked(View view){
        Intent intent = new Intent( MainActivity.this, SciencesActivity.class );
        startActivity( intent );

    }

    public  void artClicked(View view){

        Intent intent = new Intent( MainActivity.this, ArtActivity.class );
        startActivity( intent );
    }

    public void sportClicked(View view){
      Intent intent = new Intent( MainActivity.this, SportActivity.class );
      startActivity( intent );
    }

    public void animalClicked(View view){

        Intent intent = new Intent( MainActivity.this, AnimalActivity.class );
        startActivity( intent );

    }

    public void politicClicked(View view){

        Intent intent = new Intent( MainActivity.this, PoliticActivity.class );
        startActivity( intent );
    }

    public void generalClicked(View view){
      Intent intent = new Intent( this, CulturalActivity.class );
      startActivity( intent );
    }

    public void culturalClicked(View view){
        Intent intent = new Intent( MainActivity.this, GeneralActivity.class );
        startActivity( intent );
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)  {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {

            Intent intent = new Intent( MainActivity.this, AdsActivity.class );
            startActivity( intent );
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent( MainActivity.this, AdsActivity.class );
        startActivity( intent );
        finish();
        super.onBackPressed();
    }

}
