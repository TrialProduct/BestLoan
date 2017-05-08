package com.wl.atomsparenting.fragment;

import com.wl.atomsparenting.adapter.BaseListBeanAdapter;
import com.wl.atomsparenting.beans.BaseBean;
import com.wl.atomsparenting.beans.MainActivityTopticBean;

import java.util.ArrayList;

/**
 * Created by le on 2017/4/8.
 */

public class MainActivity_Toptic extends BaseListFragment{
    private ArrayList<BaseBean> beanArrayList;
    private BaseListBeanAdapter fourFragmentAdapter;

    @Override
    protected void sonStart() {
        beanArrayList = new ArrayList<>();
        MainActivityTopticBean mainActivityBean = new MainActivityTopticBean();
        beanArrayList.add(mainActivityBean);
        fourFragmentAdapter = new BaseListBeanAdapter(beanArrayList, getContext());
        setadapter(fourFragmentAdapter);
    }
}
