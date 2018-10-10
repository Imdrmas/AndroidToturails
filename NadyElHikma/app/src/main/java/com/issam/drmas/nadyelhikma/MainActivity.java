package com.issam.drmas.nadyelhikma;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


import com.google.android.gms.ads.AdView;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.content.Intent.ACTION_VIEW;

public class MainActivity extends AppCompatActivity {
    
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    
    @BindView(R.id.tabs)
    TabLayout tabLayout;
    
    @BindView(R.id.pager)
    ViewPager pager;
    
    MainPagerAdapter adapter;
    CharSequence Titles[] = {"حكــم", "أمثال", "أقوال"};

    private Context context;
    private String appName;

    public static String FACEBOOK_URL = "https://www.facebook.com/NadyAlhkma";
    public static String FACEBOOK_PAGE_ID = "437404763022006";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle(null);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent = new Intent(MainActivity.this, AdsActivity.class);
               startActivity(intent);
            }
        });

        setUpTabs();

    } //Main

    private void setUpTabs() {

        adapter = new MainPagerAdapter(this.getSupportFragmentManager(), Titles, Titles.length);
        pager.setAdapter(adapter);
        pager.setPageTransformer(true, new ZoomOutPageTransformer());
        tabLayout.setupWithViewPager(pager);
        setUpTabIcons();
    }

    private void setUpTabIcons() {

        tabLayout.getTabAt(0).setIcon(R.mipmap.ic_home);
        tabLayout.getTabAt(1).setIcon(R.mipmap.ic_star);
        tabLayout.getTabAt(2).setIcon(R.mipmap.ic_heart);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main_menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        appName  = getString(R.string.app_name);

        if (id == R.id.itemShare){

            String linkShare = "https://play.google.com/store/apps/details?id=com.issam.drmas.nadyelhikma";

            Intent intentShare = new Intent(Intent.ACTION_SEND);
            intentShare.setType("Text/plain");
            intentShare.putExtra(Intent.EXTRA_TEXT, appName + "\n" + linkShare);
            startActivity(intentShare);

            return true;
        }

        if (id == R.id.itemFacebook){

            Intent facebookIntent = new Intent(Intent.ACTION_VIEW);
            String facebookUrl = getFacebookPageUrl(this);
            facebookIntent.setData(Uri.parse(facebookUrl));
            startActivity(facebookIntent);

            return true;
        }

        if (id == R.id.itemEmail){

            try {

                String text = "Good Morning \n " + "My Suggestion is";
                Intent sendEmail = new Intent(Intent.ACTION_SEND);

                sendEmail.setData(Uri.parse("mailto"));
                sendEmail.setType("message/rfc822");
                sendEmail.putExtra(Intent.EXTRA_EMAIL, "imdrmas@yahoo.com");
                sendEmail.putExtra(Intent.EXTRA_SUBJECT, appName);
                sendEmail.putExtra(Intent.EXTRA_TEXT, text);

                startActivity(sendEmail);

            } catch (Exception e){
                Toast.makeText(this, "Sorry Cannot Find The Application", Toast.LENGTH_SHORT).show();
            }
            return true;
        }
        if (id == R.id.itemMoreApps){

            final String appPackageName = "com.drmas.issam.quizeaslamic"; //getPackageName();
            try {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id="+ appPackageName)));
            }catch (ActivityNotFoundException e){
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id="+ appPackageName)));
            }
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public String getFacebookPageUrl(Context context){

        PackageManager packageManager = context.getPackageManager();

        try {

        int versionCode = packageManager.getPackageInfo("com.facebook.NadyAlhkma", 0).versionCode;

        if (versionCode >= 3002850){
            return "fb://facewebmodal/f?href=" + FACEBOOK_URL;
        } else {
            return "fb://page/" + FACEBOOK_PAGE_ID;
        }

        } catch (PackageManager.NameNotFoundException e) {
            return FACEBOOK_URL;
        }
    }

}





















