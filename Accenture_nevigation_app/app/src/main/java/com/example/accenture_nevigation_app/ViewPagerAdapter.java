package com.example.accenture_nevigation_app;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

/**
 * Created by developer on 19/6/18.
 */

public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    private final ArrayList<Fragment>myFragments = new ArrayList<>();
    private final ArrayList<String>categories = new ArrayList<>();

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        return myFragments.get(position);
    }



    @Override
    public int getCount() {

        return categories.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {

        return categories.get(position);
    }

    public void AddFragment(Fragment fragment,String title){

        myFragments.add(fragment);
        categories.add(title);

    }
}
