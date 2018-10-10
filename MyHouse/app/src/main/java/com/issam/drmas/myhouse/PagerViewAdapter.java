package com.issam.drmas.myhouse;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class PagerViewAdapter extends FragmentPagerAdapter {

    public PagerViewAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                ProfileFragment profileFragment = new ProfileFragment();
                return profileFragment;
            case 1:
                AllUsersFragment allUsersFragment = new AllUsersFragment();
                return allUsersFragment;
            case 2:
                NotifacationFragment notifacationFragment = new NotifacationFragment();
                return notifacationFragment;

                default: return null;
        }
    }

    @Override
    public int getCount() {
        return 3;
    }
}
