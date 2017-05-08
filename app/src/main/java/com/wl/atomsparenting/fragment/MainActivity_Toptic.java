package com.wl.atomsparenting.fragment;

import com.wl.atomsparenting.adapter.FourFragmentAdapter;
import com.wl.atomsparenting.beans.BaseBean;
import com.wl.atomsparenting.beans.MainActivityTopticBean;

import java.util.ArrayList;

/**
 * Created by le on 2017/4/8.
 */

public class MainActivity_Toptic extends BaseListFragment{
    private ArrayList<BaseBean> beanArrayList;
    private FourFragmentAdapter fourFragmentAdapter;

    @Override
    protected void sonStart() {
        beanArrayList = new ArrayList<>();
        MainActivityTopticBean mainActivityBean = new MainActivityTopticBean();
        beanArrayList.add(mainActivityBean);
        fourFragmentAdapter = new FourFragmentAdapter(beanArrayList, getContext());
        setadapter(fourFragmentAdapter);
    }
}
