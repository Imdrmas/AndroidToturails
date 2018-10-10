package com.issam.drmas.mytabs;

import android.content.Intent;
import android.graphics.Color;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class MainActivity extends AppCompatActivity {

    private TextView mProfileLabel;
    private TextView mUsersLabel;
    private TextView mNotificationLabel;
    private ViewPager mMainPager;
    private PagerViewAdapter pagerViewAdapter;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();

        mProfileLabel = findViewById(R.id.txtProfile);
        mUsersLabel = findViewById(R.id.txtUsers);
        mNotificationLabel = findViewById(R.id.txtNotification);

        mMainPager = findViewById(R.id.mainPager);

        pagerViewAdapter = new PagerViewAdapter(getSupportFragmentManager());
        mMainPager.setAdapter(pagerViewAdapter);
        mMainPager.setOffscreenPageLimit(2);

        mProfileLabel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMainPager.setCurrentItem(0);
            }
        });

        mUsersLabel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMainPager.setCurrentItem(1);
            }
        });

        mNotificationLabel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMainPager.setCurrentItem(2);
            }
        });

        mMainPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                 changeTabs(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void changeTabs(int position) {

        if (position == 0){

            mProfileLabel.setTextColor(Color.WHITE);
            mProfileLabel.setTextSize(22);

            mUsersLabel.setTextColor(Color.YELLOW);
            mUsersLabel.setTextSize(16);

            mNotificationLabel.setTextColor(Color.YELLOW);
            mNotificationLabel.setTextSize(16);
        }

        if (position == 1){

            mProfileLabel.setTextColor(Color.YELLOW);
            mProfileLabel.setTextSize(16);

            mUsersLabel.setTextColor(Color.WHITE);
            mUsersLabel.setTextSize(22);

            mNotificationLabel.setTextColor(Color.YELLOW);
            mNotificationLabel.setTextSize(16);

        }

        if (position == 2){

            mProfileLabel.setTextColor(Color.YELLOW);
            mProfileLabel.setTextSize(16);

            mUsersLabel.setTextColor(Color.YELLOW);
            mUsersLabel.setTextSize(16);

            mNotificationLabel.setTextColor(Color.WHITE);
            mNotificationLabel.setTextSize(22);

        }
    }

    @Override
    protected void onStart() {

        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser == null){
            startActivity(new Intent(MainActivity.this, LoginActivity.class));
            finish();
        }
        else {
            mProfileLabel.setTextColor(Color.WHITE);
            mProfileLabel.setTextSize(22);

            mUsersLabel.setTextColor(Color.YELLOW);
            mUsersLabel.setTextSize(16);

            mNotificationLabel.setTextColor(Color.YELLOW);
            mNotificationLabel.setTextSize(16);
        }
        super.onStart();
    }
}
