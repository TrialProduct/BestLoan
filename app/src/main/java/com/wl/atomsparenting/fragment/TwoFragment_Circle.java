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
<<<<<<< HEAD
        TwoFragmentCircleBean twoFragmentCircleBean = new TwoFragmentCircleBean();
        beanArrayList.add(twoFragmentCircleBean);
        fourFragmentAdapter = new BaseListBeanAdapter(beanArrayList, getContext());
=======
        SecondFragmentCircleBean secondFragmentCircleBean = new SecondFragmentCircleBean();
        beanArrayList.add(secondFragmentCircleBean);
        fourFragmentAdapter = new FourFragmentAdapter(beanArrayList, getContext());
>>>>>>> 0644114a8c4e536627331d3955b94957889c3856
        setadapter(fourFragmentAdapter);
    }
}
