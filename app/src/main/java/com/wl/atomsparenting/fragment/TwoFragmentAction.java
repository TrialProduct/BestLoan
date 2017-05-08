package com.wl.atomsparenting.fragment;

import com.wl.atomsparenting.adapter.FourFragmentAdapter;
import com.wl.atomsparenting.beans.BaseBean;
import com.wl.atomsparenting.beans.TwoFragmentActionBean;

import java.util.ArrayList;

/**
 * Created by le on 2017/4/14.
 */

public class TwoFragmentAction extends BaseListFragment {
    private ArrayList<BaseBean> beanArrayList;
    private FourFragmentAdapter fourFragmentAdapter;

    @Override
    protected void sonStart() {
        beanArrayList = new ArrayList<>();
        TwoFragmentActionBean twoFragmentBean = new TwoFragmentActionBean();
        beanArrayList.add(twoFragmentBean);
        fourFragmentAdapter = new FourFragmentAdapter(beanArrayList, getContext());
        setadapter(fourFragmentAdapter);
    }
}
