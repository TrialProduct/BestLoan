package com.wl.atomsparenting.cards;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;

import com.wl.atomsparenting.R;
import com.wl.atomsparenting.adapter.GoodTrickAdapter;
import com.wl.atomsparenting.beans.BaseBean;
import com.wl.atomsparenting.contentprovider.Data;
import com.wl.atomsparenting.contentprovider.SQLiteColumn;
import com.wl.atomsparenting.domain.GriddoGoodTrick;
import com.wl.atomsparenting.views.HeaderGridView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by le on 2017/4/17.
 */

public class GridView2Card extends BaseCard {
    private String mpath = "content://com.wl.atomsparenting.contentprovider/atomsparentingtable";
    private ContentResolver mresolver;


    private GoodTrickAdapter mgridbaseadapter;

    private ArrayList<GriddoGoodTrick> mlistgoodtrick;
    private HeaderGridView mrecyclerview;



    public GridView2Card(@NonNull Context context) {
        super(context);
    }

    public GridView2Card(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected int getFindView() {
        return R.layout.gridview2card;
    }

    @Override
    protected void getMaterial() {
        mrecyclerview = (HeaderGridView) mView.findViewById(R.id.main_goodtrick_recyclerview);
        mrecyclerview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });

        mlistgoodtrick = new ArrayList<>();
        mgridbaseadapter = new GoodTrickAdapter(mlistgoodtrick, mContext);
        mrecyclerview.setAdapter(mgridbaseadapter);

    }

    @Override
    public void bindBean(BaseBean baseBean) {
        initrecyclerview();
    }

    private void initrecyclerview() {


        getdata();
    }

    private void getdata() {


        mresolver = getContext().getContentResolver();



        ArrayList<Data> dataArrayList = new ArrayList<>();
        Cursor cursor = mresolver.query(Uri.parse(mpath), null, null, null, null);

        if (cursor != null) {
            while (cursor.moveToNext()) {
                String recordType = cursor.getString(cursor.getColumnIndex(SQLiteColumn.RECORDTYPE));
                String jsonString = cursor.getString(cursor.getColumnIndex(SQLiteColumn.JSONSTRING));
                Data data = new Data(recordType, jsonString);
                dataArrayList.add(data);
                if (cursor == null) {
                    break;
                }
            }

            for (int j = 0; j < dataArrayList.size(); j++) {

                if (dataArrayList.get(j).getRecordType().equals("hotCoupBeen")) {

                    try {
                        mlistgoodtrick.clear();
                        JSONArray jsonArray = new JSONArray(dataArrayList.get(j).getJsonString());
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject jo = jsonArray.getJSONObject(i);
                            String strPicUrl = jo.getString("strPicUrl");
                            String strTitle = jo.getString("strTitle");
                            String strAuthor = jo.getString("strAuthor");
                            int intLike = jo.getInt("intLike");
                            GriddoGoodTrick griddomaiozhao = new GriddoGoodTrick(strPicUrl, strTitle, intLike, strAuthor);
                            mlistgoodtrick.add(griddomaiozhao);

                        }
                        mgridbaseadapter.notifyDataSetChanged();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

            }




        }
    }
}
