package com.wl.atomsparenting.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by le on 2017/4/7.
 */

public class FragmentAdapter extends FragmentPagerAdapter {
    ArrayList<Fragment> list;

    public FragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    public FragmentAdapter(FragmentManager fm, ArrayList<Fragment> list) {
        super(fm);
        this.list = list;
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);

    }

    @Override
    public int getCount() {
        return list.size();
    }
}
