package com.wl.atomsparenting.fragment;

import com.wl.atomsparenting.adapter.BaseListBeanAdapter;
import com.wl.atomsparenting.beans.BaseBean;
import com.wl.atomsparenting.beans.SecondFragmentCircleBean;

import java.util.ArrayList;

/**
 * Created by le on 2017/4/14.
 */

public class TwoFragment_Circle extends BaseListFragment {
    private ArrayList<BaseBean> beanArrayList;
    private BaseListBeanAdapter fourFragmentAdapter;

    @Override
    protected void sonStart() {
        beanArrayList = new ArrayList<>();
        SecondFragmentCircleBean gridView2Bean = new SecondFragmentCircleBean();
        beanArrayList.add(gridView2Bean);
        fourFragmentAdapter = new BaseListBeanAdapter(beanArrayList, getContext());
        setadapter(fourFragmentAdapter);

    }
}
