package com.wl.atomsparenting.cards;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.GridView;

import com.wl.atomsparenting.R;
import com.wl.atomsparenting.adapter.Gridbaseadapter;
import com.wl.atomsparenting.beans.BaseBean;
import com.wl.atomsparenting.domain.Griddomain;

import java.util.ArrayList;

/**
 * Created by le on 2017/4/17.
 */

public class GridView1Card extends BaseCard {
    private GridView gridview;
    private Gridbaseadapter adapter;
    private ArrayList<Griddomain> list;
    private int image[] = {
            R.drawable.gushi,
            R.drawable.jiankang,
            R.drawable.yingwen,
            R.drawable.icon_podcast_psychology,
            R.drawable.shougong,
            R.drawable.ziran,
            R.drawable.yishu,
            R.drawable.letu,
            R.drawable.icon_podcast_food,
            R.drawable.icon_podcast_more
    };
    private String strname[] = {
            "故事", "健康", "英文", "心理", "手工", "自然", "艺术", "乐途", "美食", "更多"
    };

    public GridView1Card(@NonNull Context context) {
        super(context);
    }

    public GridView1Card(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected int getFindView() {
        return R.layout.gridview1card;
    }

    @Override
    protected void getMaterial() {
        gridview = (GridView) mView.findViewById(R.id.maingoodtrick_gridview);


    }

    @Override
    public void bindBean(BaseBean baseBean) {
        list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Griddomain gd = new Griddomain(image[i], strname[i]);
            list.add(gd);
        }
        adapter = new Gridbaseadapter(list, mContext);
        gridview.setAdapter(adapter);
    }
}
