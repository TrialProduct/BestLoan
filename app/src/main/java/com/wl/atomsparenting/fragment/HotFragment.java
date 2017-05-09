package com.wl.atomsparenting.fragment;

import com.wl.atomsparenting.adapter.FourFragmentAdapter;
import com.wl.atomsparenting.beans.BaseBean;
import com.wl.atomsparenting.beans.TwoFragmentActionBean;

import java.util.ArrayList;

/**
 * Created by le on 2017/4/14.
 */

public class HotFragment extends BaseListFragment {
    private ArrayList<BaseBean> beanArrayList;
    private FourFragmentAdapter fourFragmentAdapter;

    @Override
    protected void sonStart() {
        beanArrayList = new ArrayList<>();
        TwoFragmentActionBean hotBean = new TwoFragmentActionBean();
        beanArrayList.add(hotBean);
        fourFragmentAdapter = new FourFragmentAdapter(beanArrayList, getContext());
        setadapter(fourFragmentAdapter);
    }
}
