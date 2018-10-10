package com.issam.drmas.frenchverbsconjugator;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class MainPagerAdapter extends FragmentPagerAdapter {

    CharSequence Titles[];
    int NumOfTabs;

    public MainPagerAdapter(FragmentManager fm, CharSequence mTitles[], int numOfTabs) {
        super(fm);

        this.Titles = mTitles;
        this.NumOfTabs = numOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        if (position == 0){
            VerbsFragment verbsFragment = new VerbsFragment();
            return verbsFragment;
        }
        if (position == 1){
            ExercisesFragment exercisesFragment = new ExercisesFragment();
            return exercisesFragment;
        }
        else {
            GrammarFragment grammarFragment = new GrammarFragment();
            return grammarFragment;
        }

    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return Titles[position];
    }

    @Override
    public int getCount() {
        return NumOfTabs;
    }
}
