package com.drmas.issam.sharefood;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginManager;
import com.squareup.picasso.Picasso;

public class ProfileActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    @Override protected void onCreate(Bundle savedInstanceState) { super.onCreate(savedInstanceState);

        FacebookSdk.sdkInitialize(getApplicationContext()); setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar); setSupportActionBar(toolbar);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.ad_image_view); ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        assert drawer != null;
        drawer.setDrawerListener(toggle);

        toggle.syncState(); NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        assert navigationView != null; View headerLayout = navigationView.getHeaderView(0);
        navigationView.setNavigationItemSelectedListener(this);

        String profileUserID = returnValueFromBundles(FacebookActivity.PROFILE_USER_ID);
        String profileFirstName = returnValueFromBundles(FacebookActivity.PROFILE_FIRST_NAME);
        String profileLastName = returnValueFromBundles(FacebookActivity.PROFILE_LAST_NAME);
        String profileImageLink = returnValueFromBundles(FacebookActivity.PROFILE_IMAGE_URL); profileName.setText(profileFirstName + " " + profileLastName); profileUserId.setText("User ID : " + profileUserID);

        Picasso.with(ProfileActivity.this).load(profileImageLink).into(profileView);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout); assert drawer != null;
        if (drawer.isDrawerOpen(GravityCompat.START)) { drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
// Inflate the menu; this adds items to the action bar if it is present. getMenuInflater().inflate(R.menu.profile, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
// Handle action bar item clicks here. The action bar will // automatically handle clicks on the Home/Up button, so long // as you specify a parent activity in AndroidManifest.xml.

        int id = item.getItemId();
//noinspection SimplifiableIfStatement
        if (id == R.id.action_logout) {
            LoginManager.getInstance().logOut();
            Intent logoutIntent = new Intent(ProfileActivity.this, FacebookActivity.class); startActivity(logoutIntent);
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);

    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
// Handle navigation view item clicks here.
        int id = item.getItemId();
        if (id == R.id.nav_camera) {
// Handle the camera action
        } else if (id == R.id.nav_gallery) {
        } else if (id == R.id.nav_slideshow) {
        } else if (id == R.id.nav_manage) {
        } else if (id == R.id.nav_share) {
        } else if (id == R.id.nav_send) {
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout); drawer.closeDrawer(GravityCompat.START); return true;
    }

    private String returnValueFromBundles(String key){
        Bundle inBundle = getIntent().getExtras();
        String returnedValue = inBundle.get(key).toString();
        return returnedValue;
    }
}