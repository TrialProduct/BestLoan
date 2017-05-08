package com.wl.atomsparenting.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.wl.atomsparenting.R;

import java.util.ArrayList;

/**
 * Created by le on 2017/4/14.
 */

public class ThreeFragmentRecyclerView extends RecyclerView.Adapter<ThreeFragmentRecyclerView.ViewHolder> {
    private ArrayList<Integer> list;
    private Context context;
    private LayoutInflater inflater;

    public ThreeFragmentRecyclerView(ArrayList<Integer> list, Context context) {
        this.list = list;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.three_recyclerview_item, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.three_item_img.setImageResource(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView three_item_img;

        public ViewHolder(View itemView) {
            super(itemView);
            three_item_img = (ImageView) itemView.findViewById(R.id.three_item_img);
        }
    }
}
