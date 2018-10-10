package com.issam.drmas.nadyelhikma;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class MainPagerAdapter extends FragmentPagerAdapter {

    CharSequence Titles[];
    int NumOfTabs;

    public MainPagerAdapter(FragmentManager fm, CharSequence mTitles[], int NimOfTabs) {
        super(fm);

        this.Titles = mTitles;
        this.NumOfTabs = NimOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        if (position == 0){
            OneFragment oneFragment = new OneFragment();
            return oneFragment;
        }
        if (position == 1){
            TwoFragment twoFragment = new TwoFragment();
            return twoFragment;
        }
        else {
            ThreeFragment threeFragment = new ThreeFragment();
            return threeFragment;
        }

    }

    @Override
    public CharSequence getPageTitle(int position){
        return Titles[position];
    }

    @Override
    public int getCount() {
        return NumOfTabs;
    }
}
