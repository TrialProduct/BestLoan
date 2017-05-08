package com.wl.atomsparenting.cards;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.GridView;

import com.wl.atomsparenting.R;
import com.wl.atomsparenting.adapter.OptionAdapter;
import com.wl.atomsparenting.beans.BaseBean;
import com.wl.atomsparenting.domain.Griddomain;

import java.util.ArrayList;

/**
 * Created by le on 2017/4/17.
 */

<<<<<<< HEAD:app/src/main/java/com/wl/atomsparenting/cards/GridView1Card.java
public class GridView1Card extends BaseCard {
    private GridView gridview;
    private OptionAdapter adapter;
    private ArrayList<Griddomain> list;
    private int image[] = {
            R.drawable.gushi,
            R.drawable.jiankang,
            R.drawable.yingwen,
=======
public class GridView1Cardsys extends BaseCard {
    private GridView mgv;
    private Gridbaseadapter madapter;
    private ArrayList<Griddomain> mlist;
    private int mimage[] = {
            R.drawable.story,
            R.drawable.Health,
            R.drawable.english,
>>>>>>> 0644114a8c4e536627331d3955b94957889c3856:app/src/main/java/com/wl/atomsparenting/cards/GridView1Cardsys.java
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
<<<<<<< HEAD:app/src/main/java/com/wl/atomsparenting/cards/GridView1Card.java
        adapter = new OptionAdapter(list, mContext);
        gridview.setAdapter(adapter);
=======
        madapter = new Gridbaseadapter(mlist, mContext);
        mgv.setAdapter(madapter);
>>>>>>> 0644114a8c4e536627331d3955b94957889c3856:app/src/main/java/com/wl/atomsparenting/cards/GridView1Cardsys.java
    }
}
