package com.wl.atomsparenting.cards;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

import com.wl.atomsparenting.R;
import com.wl.atomsparenting.beans.BaseBean;

/**
 * Created by le on 2017/4/17.
 */

public class TwoFragmentActionCard extends BaseCard {
    public TwoFragmentActionCard(@NonNull Context context) {
        super(context);
    }

    public TwoFragmentActionCard(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected int getFindView() {
        return R.layout.twofragmentaction;
    }

    @Override
    protected void getMaterial() {

    }

    @Override
    public void bindBean(BaseBean baseBean) {

    }
}
