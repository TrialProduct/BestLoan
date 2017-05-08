package com.wl.atomsparenting.adapter;

import android.content.Context;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.wl.atomsparenting.beans.BaseBean;
import com.wl.atomsparenting.beans.GridView1Bean;
import com.wl.atomsparenting.beans.GridView2Bean;
import com.wl.atomsparenting.beans.MainActivityTopticBean;
import com.wl.atomsparenting.beans.RollPagerView2Bean;
import com.wl.atomsparenting.beans.RollPagerViewBean;
import com.wl.atomsparenting.beans.SecondFragmentActionBean;
import com.wl.atomsparenting.beans.SecondFragmentCircleBean;
import com.wl.atomsparenting.beans.TarentoBean;
import com.wl.atomsparenting.beans.ThirdSmallClassBean;
import com.wl.atomsparenting.cards.BaseCard;
import com.wl.atomsparenting.cards.GridView1Cardsys;
import com.wl.atomsparenting.cards.GridView2Card;
import com.wl.atomsparenting.cards.MainActivityTopticCard;
import com.wl.atomsparenting.cards.RollPagerView2Card;
import com.wl.atomsparenting.cards.RollPagerViewCard;
import com.wl.atomsparenting.cards.SecondFragmentActionCard;
import com.wl.atomsparenting.cards.SecondFragmentCircleCard;
import com.wl.atomsparenting.cards.TarentoCard;
import com.wl.atomsparenting.cards.ThirdSmallClassCard;

import java.util.ArrayList;

/**
 * Created by le on 2017/4/14.
 */

public class BaseListBeanAdapter extends RecyclerView.Adapter<BaseListBeanAdapter.FourViewHolder> {
    private ArrayList<BaseBean> mArrayList;
    private Context mContext;

    public BaseListBeanAdapter(ArrayList<BaseBean> mArrayList, Context mContext) {
        this.mArrayList = mArrayList;
        this.mContext = mContext;
    }

    @Override
    public FourViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = null;

        if (viewType == RollPagerViewBean.class.getCanonicalName().hashCode()) {
            view = new RollPagerViewCard(mContext);
        } else if (viewType == GridView1Bean.class.getCanonicalName().hashCode()) {
<<<<<<< HEAD:app/src/main/java/com/wl/atomsparenting/adapter/BaseListBeanAdapter.java
            view = new GridView1Card(mContext);
=======
            view = new GridView1Cardsys(context);
>>>>>>> 0644114a8c4e536627331d3955b94957889c3856:app/src/main/java/com/wl/atomsparenting/adapter/FourFragmentAdapter.java
        } else if (viewType == TarentoBean.class.getCanonicalName().hashCode()) {
            view = new TarentoCard(mContext);
        } else if (viewType == GridView2Bean.class.getCanonicalName().hashCode()) {
            view = new GridView2Card(mContext);
        } else if (viewType == MainActivityTopticBean.class.getCanonicalName().hashCode()) {
<<<<<<< HEAD:app/src/main/java/com/wl/atomsparenting/adapter/BaseListBeanAdapter.java
            view = new MainActivityTopticCard(mContext);
        } else if (viewType == TwoFragmentCircleBean.class.getCanonicalName().hashCode()) {
            view = new TwoFragmentCircleCard(mContext);
        } else if (viewType == TwoFragmentActionBean.class.getCanonicalName().hashCode()) {
            view = new TwoFragmentActionCard(mContext);
        } else if (viewType == ThreeSmallClassBean.class.getCanonicalName().hashCode()) {
            view = new ThreeSmallClassCard(mContext);
=======
            view = new MainActivityTopticCard(context);

        } else if (viewType == SecondFragmentCircleBean.class.getCanonicalName().hashCode()) {
            view = new SecondFragmentActionCard(context);
        } else if (viewType == SecondFragmentActionBean.class.getCanonicalName().hashCode()) {
            view = new SecondFragmentActionCard(context);
        } else if (viewType == ThirdSmallClassBean.class.getCanonicalName().hashCode()) {
            view = new ThirdSmallClassCard(context);

        } else if (viewType == SecondFragmentActionCard.class.getCanonicalName().hashCode()) {
            view = new SecondFragmentCircleCard(context);
        } else if (viewType == SecondFragmentActionCard.class.getCanonicalName().hashCode()) {
            view = new SecondFragmentActionCard(context);
        } else if (viewType == ThirdSmallClassBean.class.getCanonicalName().hashCode()) {
            view = new ThirdSmallClassCard(context);
<<<<<<< HEAD:app/src/main/java/com/wl/atomsparenting/adapter/FourFragmentAdapter.java

=======
>>>>>>> 0824dcbf302978b2cda6d494d04e7a1c9a0aa1d1
>>>>>>> 0644114a8c4e536627331d3955b94957889c3856:app/src/main/java/com/wl/atomsparenting/adapter/FourFragmentAdapter.java
>>>>>>> b8ddbc0647c89d1da3defc209aa371abfd24ed64:app/src/main/java/com/wl/atomsparenting/adapter/BaseListBeanAdapter.java
        } else if (viewType == RollPagerView2Bean.class.getCanonicalName().hashCode()) {
            view = new RollPagerView2Card(mContext);
        }

        return new FourViewHolder(view);
    }

    @Override
    public void onBindViewHolder(FourViewHolder holder, int position) {
        ((BaseCard) holder.itemView).bindBean(mArrayList.get(position));
    }

    @Override
    public int getItemCount() {
        return mArrayList.size();
    }

    @Override
    public int getItemViewType(int position) {

        int viewtype = -1;

        if (mArrayList.get(position) instanceof RollPagerViewBean) {
            viewtype = RollPagerViewBean.class.getCanonicalName().hashCode();
        } else if (mArrayList.get(position) instanceof GridView1Bean) {
            viewtype = GridView1Bean.class.getCanonicalName().hashCode();
        } else if (mArrayList.get(position) instanceof TarentoBean) {
            viewtype = TarentoBean.class.getCanonicalName().hashCode();
        } else if (mArrayList.get(position) instanceof GridView2Bean) {
            viewtype = GridView2Bean.class.getCanonicalName().hashCode();
        } else if (mArrayList.get(position) instanceof MainActivityTopticBean) {
            viewtype = MainActivityTopticBean.class.getCanonicalName().hashCode();
<<<<<<< HEAD:app/src/main/java/com/wl/atomsparenting/adapter/BaseListBeanAdapter.java
        } else if (mArrayList.get(position) instanceof TwoFragmentCircleBean) {
            viewtype = TwoFragmentCircleBean.class.getCanonicalName().hashCode();
        } else if (mArrayList.get(position) instanceof TwoFragmentActionBean) {
            viewtype = TwoFragmentActionBean.class.getCanonicalName().hashCode();
        } else if (mArrayList.get(position) instanceof ThreeSmallClassBean) {
            viewtype = ThreeSmallClassBean.class.getCanonicalName().hashCode();
        }else if (mArrayList.get(position) instanceof RollPagerView2Bean) {
=======
        } else if (list.get(position) instanceof SecondFragmentCircleBean) {
            viewtype = SecondFragmentCircleBean.class.getCanonicalName().hashCode();
        } else if (list.get(position) instanceof SecondFragmentActionBean) {
            viewtype = SecondFragmentActionBean.class.getCanonicalName().hashCode();
        } else if (list.get(position) instanceof ThirdSmallClassBean) {
            viewtype = ThirdSmallClassBean.class.getCanonicalName().hashCode();
        }else if (list.get(position) instanceof RollPagerView2Bean) {
>>>>>>> 0644114a8c4e536627331d3955b94957889c3856:app/src/main/java/com/wl/atomsparenting/adapter/FourFragmentAdapter.java
            viewtype = RollPagerView2Bean.class.getCanonicalName().hashCode();
        }

        return viewtype;
    }

    class FourViewHolder extends RecyclerView.ViewHolder {

        public FourViewHolder(View itemView) {
            super(itemView);
        }
    }
}
