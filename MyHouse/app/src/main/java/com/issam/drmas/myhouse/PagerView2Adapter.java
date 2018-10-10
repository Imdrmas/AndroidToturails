package com.issam.drmas.myhouse;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class PagerView2Adapter extends FragmentPagerAdapter {
    public PagerView2Adapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
       switch (position){
           case 0:
               MoneyFragment moneyFragment = new MoneyFragment();
               return moneyFragment;

           case 1:
               SpendFragment spendFragment = new SpendFragment();
               return spendFragment;

           case 2:
               NoteFragment noteFragment = new NoteFragment();
               return noteFragment;

               default:
                   return null;
       }
    }

    @Override
    public int getCount() {
        return 3;
    }
}
