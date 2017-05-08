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

public class GridView1Cardsys extends BaseCard {
    private GridView mgv;
    private Gridbaseadapter madapter;
    private ArrayList<Griddomain> mlist;
    private int mimage[] = {
            R.drawable.story,
            R.drawable.Health,
            R.drawable.english,
            R.drawable.icon_podcast_psychology,
            R.drawable.handwork,
            R.drawable.nature,
            R.drawable.art,
            R.drawable.happy_journey,
            R.drawable.icon_podcast_food,
            R.drawable.icon_podcast_more
    };
    private String mstrname[] = {
            "故事", "健康", "英文", "心理", "手工", "自然", "艺术", "乐途", "美食", "更多"
    };

    public GridView1Cardsys(@NonNull Context context) {
        super(context);
    }

    public GridView1Cardsys(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected int getFindView() {
        return R.layout.gridview1card;
    }

    @Override
    protected void getMaterial() {
        mgv = (GridView) mView.findViewById(R.id.maingoodtrick_gridview);


    }

    @Override
    public void bindBean(BaseBean baseBean) {
        mlist = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Griddomain gd = new Griddomain(mimage[i], mstrname[i]);
            mlist.add(gd);
        }
        madapter = new Gridbaseadapter(mlist, mContext);
        mgv.setAdapter(madapter);
    }
}
