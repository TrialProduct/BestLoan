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
import com.wl.atomsparenting.beans.TarentoBean;
import com.wl.atomsparenting.beans.ThirdSmallClassBean;
import com.wl.atomsparenting.beans.SecondFragmentActionBean;
import com.wl.atomsparenting.beans.SecondFragmentCircleBean;
import com.wl.atomsparenting.cards.BaseCard;
import com.wl.atomsparenting.cards.GridView1Cardsys;
import com.wl.atomsparenting.cards.GridView2Card;
import com.wl.atomsparenting.cards.MainActivityTopticCard;
import com.wl.atomsparenting.cards.RollPagerView2Card;
import com.wl.atomsparenting.cards.RollPagerViewCard;
import com.wl.atomsparenting.cards.TarentoCard;
import com.wl.atomsparenting.cards.ThirdSmallClassCard;
import com.wl.atomsparenting.cards.SecondFragmentActionCard;
import com.wl.atomsparenting.cards.SecondFragmentCircleCard;

import java.util.ArrayList;

/**
 * Created by le on 2017/4/14.
 */

public class FourFragmentAdapter extends RecyclerView.Adapter<FourFragmentAdapter.FourViewHolder> {
    private ArrayList<BaseBean> list;
    private Context context;

    public FourFragmentAdapter(ArrayList<BaseBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public FourViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;

        if (viewType == RollPagerViewBean.class.getCanonicalName().hashCode()) {
            view = new RollPagerViewCard(context);
        } else if (viewType == GridView1Bean.class.getCanonicalName().hashCode()) {
            view = new GridView1Cardsys(context);
        } else if (viewType == TarentoBean.class.getCanonicalName().hashCode()) {
            view = new TarentoCard(context);
        } else if (viewType == GridView2Bean.class.getCanonicalName().hashCode()) {
            view = new GridView2Card(context);
        } else if (viewType == MainActivityTopticBean.class.getCanonicalName().hashCode()) {
            view = new MainActivityTopticCard(context);
<<<<<<< HEAD
        } else if (viewType == SecondFragmentCircleBean.class.getCanonicalName().hashCode()) {
            view = new TwoFragmentCircleCard(context);
        } else if (viewType == SecondFragmentActionBean.class.getCanonicalName().hashCode()) {
            view = new TwoFragmentActionCard(context);
        } else if (viewType == ThirdSmallClassBean.class.getCanonicalName().hashCode()) {
            view = new ThreeSmallClassCard(context);
=======
        } else if (viewType == TwoFragmentCircleBean.class.getCanonicalName().hashCode()) {
            view = new SecondFragmentCircleCard(context);
        } else if (viewType == TwoFragmentActionBean.class.getCanonicalName().hashCode()) {
            view = new SecondFragmentActionCard(context);
        } else if (viewType == ThreeSmallClassBean.class.getCanonicalName().hashCode()) {
            view = new ThirdSmallClassCard(context);
>>>>>>> 0824dcbf302978b2cda6d494d04e7a1c9a0aa1d1
        } else if (viewType == RollPagerView2Bean.class.getCanonicalName().hashCode()) {
            view = new RollPagerView2Card(context);
        }

        return new FourViewHolder(view);
    }

    @Override
    public void onBindViewHolder(FourViewHolder holder, int position) {
        ((BaseCard) holder.itemView).bindBean(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public int getItemViewType(int position) {
        int viewtype = -1;

        if (list.get(position) instanceof RollPagerViewBean) {
            viewtype = RollPagerViewBean.class.getCanonicalName().hashCode();
        } else if (list.get(position) instanceof GridView1Bean) {
            viewtype = GridView1Bean.class.getCanonicalName().hashCode();
        } else if (list.get(position) instanceof TarentoBean) {
            viewtype = TarentoBean.class.getCanonicalName().hashCode();
        } else if (list.get(position) instanceof GridView2Bean) {
            viewtype = GridView2Bean.class.getCanonicalName().hashCode();
        } else if (list.get(position) instanceof MainActivityTopticBean) {
            viewtype = MainActivityTopticBean.class.getCanonicalName().hashCode();
        } else if (list.get(position) instanceof SecondFragmentCircleBean) {
            viewtype = SecondFragmentCircleBean.class.getCanonicalName().hashCode();
        } else if (list.get(position) instanceof SecondFragmentActionBean) {
            viewtype = SecondFragmentActionBean.class.getCanonicalName().hashCode();
        } else if (list.get(position) instanceof ThirdSmallClassBean) {
            viewtype = ThirdSmallClassBean.class.getCanonicalName().hashCode();
        }else if (list.get(position) instanceof RollPagerView2Bean) {
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
