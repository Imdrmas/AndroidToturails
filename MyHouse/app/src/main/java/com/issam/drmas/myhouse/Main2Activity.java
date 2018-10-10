package com.issam.drmas.myhouse;

import android.content.Intent;
import android.graphics.Color;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Main2Activity extends AppCompatActivity {

    private TextView mMoneyLabel;
    private TextView mSpendLabel;
    private TextView mNoteLabel;
    private ViewPager mMainPager2;
    private PagerView2Adapter pagerView2Adapter;

    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        mAuth = FirebaseAuth.getInstance();

        mMoneyLabel = findViewById(R.id.txtMoney);
        mSpendLabel = findViewById(R.id.txtSpend);
        mNoteLabel = findViewById(R.id.txtNote);

        mMainPager2 = findViewById(R.id.mainPager2);

        pagerView2Adapter = new PagerView2Adapter(getSupportFragmentManager());
        mMainPager2.setAdapter(pagerView2Adapter);
        mMainPager2.setOffscreenPageLimit(2);

        mMoneyLabel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMainPager2.setCurrentItem(0);
            }
        });

        mSpendLabel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMainPager2.setCurrentItem(1);
            }
        });

        mNoteLabel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMainPager2.setCurrentItem(2);
            }
        });

        mMainPager2.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
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

            mMoneyLabel.setTextColor(Color.WHITE);
            mMoneyLabel.setTextSize(22);

            mSpendLabel.setTextColor(Color.YELLOW);
            mSpendLabel.setTextSize(16);

            mNoteLabel.setTextColor(Color.YELLOW);
            mNoteLabel.setTextSize(16);
        }

        if (position == 1){

            mMoneyLabel.setTextColor(Color.YELLOW);
            mMoneyLabel.setTextSize(16);

            mSpendLabel.setTextColor(Color.WHITE);
            mSpendLabel.setTextSize(22);

            mNoteLabel.setTextColor(Color.YELLOW);
            mNoteLabel.setTextSize(16);

        }

        if (position == 2){

            mMoneyLabel.setTextColor(Color.YELLOW);
            mMoneyLabel.setTextSize(16);

            mSpendLabel.setTextColor(Color.YELLOW);
            mSpendLabel.setTextSize(16);

            mNoteLabel.setTextColor(Color.WHITE);
            mNoteLabel.setTextSize(22);

        }
    }

    @Override
    protected void onStart() {

            mMoneyLabel.setTextColor(Color.WHITE);
            mMoneyLabel.setTextSize(22);

            mSpendLabel.setTextColor(Color.YELLOW);
            mSpendLabel.setTextSize(16);

            mNoteLabel.setTextColor(Color.YELLOW);
            mNoteLabel.setTextSize(16);

        super.onStart();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(Main2Activity.this, SetupActivity.class));
    }
}
