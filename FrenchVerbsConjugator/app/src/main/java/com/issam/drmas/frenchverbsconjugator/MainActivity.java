package com.issam.drmas.frenchverbsconjugator;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;

import android.os.Build;
import android.support.design.widget.TabLayout;
import android.support.transition.Slide;
import android.support.transition.TransitionInflater;
import android.support.v4.view.ViewPager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    android.support.v7.widget.Toolbar toolbar;

    @BindView(R.id.tabs)
    TabLayout tabLayout;

    @BindView(R.id.pager)
    ViewPager pager;

    MainPagerAdapter adapter;
    CharSequence Titles[] = {"Verbs", "Exercises", "Grammar"};
    
    private Context context;
    private String appName;

    public static String FACEBOOK_URL = "https://www.facebook.com/apprenez12";
    public static String FACEBOOK_PAGE_ID = "329967313701208";

    private InterstitialAd ad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(null);
        
        setUpTabs();
        adInterstitial();

    }

    private void setUpTabs() {
        
        adapter = new MainPagerAdapter(this.getSupportFragmentManager(), Titles, Titles.length);
        pager.setPageTransformer(true, new ZoomOutPageTransformer());
        pager.setAdapter(adapter);
        tabLayout.setupWithViewPager(pager);

        pager.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                v.getParent().requestDisallowInterceptTouchEvent(true);
                return false;
            }
        });

        pager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener(){
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                pager.getParent().requestDisallowInterceptTouchEvent(true);
            }
        });

        setUpTabsIcons();
    }

    private void setUpTabsIcons() {
        
        tabLayout.getTabAt(0).setIcon(R.mipmap.ic_verb);
        tabLayout.getTabAt(1).setIcon(R.mipmap.ic_exercise);
        tabLayout.getTabAt(2).setIcon(R.mipmap.ic_grammar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        
        int id = item.getItemId();
        appName = getString(R.string.app_name);

        if (id == R.id.searchClicked){
            startActivity(new Intent(MainActivity.this, SearchActivity.class));
        }

        if (id == R.id.itemTopScore){

            if (ad.isLoaded()) {
                ad.show();
            } else {

                Intent intent = new Intent( MainActivity.this, TopScoreActivity.class );
                startActivity( intent );
            }
            return true;
        }

        if (id == R.id.itemShare){

            String txtShare = this.getString( R.string.app_name );
            String shareLink = "https://play.google.com/store/apps/details?id=com.issam.drmas.frenchverbsconjugator";

            Intent share = new Intent(Intent.ACTION_SEND);
            share.setType("text/plain");

            share.putExtra(Intent.EXTRA_TEXT,txtShare + "\n" + shareLink);
            startActivity(share);

            return true;
        }
        
        if (id == R.id.itemFacebook){
            
            Intent intentFacebook = new Intent(Intent.ACTION_VIEW);
            String urlFacebook = getFacebookPageUrl(this);
            intentFacebook.setData(Uri.parse(urlFacebook));
            startActivity(intentFacebook);

            return true;
        }

        if(id == R.id.itemMoreApps){

            Intent intent = new Intent(MainActivity.this, AdsActivity.class);
            startActivity(intent);
            finish();

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private String getFacebookPageUrl(Context context) {

        PackageManager packageManager = context.getPackageManager();

        try {

            int versionCode = packageManager.getPackageInfo("com.issam.drmas.frenchverbsconjugator", 0).versionCode;

            if (versionCode >= 3002850){
                return "fb://facewebmodal/f?href=" + FACEBOOK_URL;
            } else {
                return "fb://page/" + FACEBOOK_PAGE_ID;
            }

        } catch (PackageManager.NameNotFoundException e){
            return FACEBOOK_URL;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    private void adInterstitial(){
        ad = new InterstitialAd(this);
        ad.setAdUnitId("ca-app-pub-7401879888732563/8371161842");

        ad.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                requestNewInterstitial();

                Intent intent = new Intent( MainActivity.this, TopScoreActivity.class );
                startActivity( intent );
            }
        });

        requestNewInterstitial();
    }

    private void requestNewInterstitial() {
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice("SEE_YOUR_LOGCAT_TO_GET_YOUR_DEVICE_ID")
                .build();

        ad.loadAd(adRequest);
    }

}
