package com.wl.atomsparenting.cards;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

import com.wl.atomsparenting.beans.BaseBean;

/**
 * Created by le on 2017/4/14.
 */

public abstract class BaseCard extends FrameLayout {
    protected View mView;
    protected Context mContext;

    public BaseCard(@NonNull Context context) {
        super(context);
        init(context);
    }


    public BaseCard(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {
        mView = inflate(context, getFindView(), this);
        mContext = context;
        getMaterial();

    }

    protected abstract int getFindView();

    protected abstract void getMaterial();

    public abstract void bindBean(BaseBean baseBean);
}
