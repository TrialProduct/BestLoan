package com.wl.atomsparenting.fragment;

import com.wl.atomsparenting.adapter.BaseListBeanAdapter;

import com.wl.atomsparenting.beans.BaseBean;
import com.wl.atomsparenting.beans.SecondFragmentActionBean;


import java.util.ArrayList;

/**
 * Created by le on 2017/4/14.
 */

public class HotFragment extends BaseListFragment {
    private ArrayList<BaseBean> beanArrayList;
    private BaseListBeanAdapter fourFragmentAdapter;

    @Override
    protected void sonStart() {
        beanArrayList = new ArrayList<>();
        SecondFragmentActionBean hotBean = new SecondFragmentActionBean();
        beanArrayList.add(hotBean);
        fourFragmentAdapter = new BaseListBeanAdapter(beanArrayList, getContext());
        setadapter(fourFragmentAdapter);
    }
}
