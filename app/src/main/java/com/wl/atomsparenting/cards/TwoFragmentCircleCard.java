package com.wl.atomsparenting.cards;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

import com.wl.atomsparenting.R;
import com.wl.atomsparenting.adapter.TwoFragment_circle_ListAdapter;
import com.wl.atomsparenting.beans.BaseBean;
import com.wl.atomsparenting.contentprovider.Data;
import com.wl.atomsparenting.contentprovider.SQLiteColumn;
import com.wl.atomsparenting.domain.CircleBean;
import com.wl.atomsparenting.views.CursorListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by le on 2017/4/17.
 */

public class TwoFragmentCircleCard extends BaseCard {
    private String mpath = "content://com.wl.atomsparenting.contentprovider/atomsparentingtable";
    private ContentResolver mresolver;

    private CursorListView mlv;
    private ArrayList<CircleBean> mlist;
    private TwoFragment_circle_ListAdapter tql;

    public TwoFragmentCircleCard(@NonNull Context context) {
        super(context);
    }

    public TwoFragmentCircleCard(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected int getFindView() {
        return R.layout.twofragment_circle;
    }

    @Override
    protected void getMaterial() {
        mlv = (CursorListView) mView.findViewById(R.id.twofragment_circle_listview);
        mlist = new ArrayList<>();
        tql = new TwoFragment_circle_ListAdapter(mlist, mContext);
        mlv.setAdapter(tql);

    }

    @Override
    public void bindBean(BaseBean baseBean) {


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

                if (dataArrayList.get(j).getRecordType().equals("circleBeen")) {

                    JSONArray jsonArray = null;
                    try {
                        mlist.clear();
                        jsonArray = new JSONArray(dataArrayList.get(j).getJsonString());
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject jo=jsonArray.getJSONObject(i);
                            String strListPicUrl=jo.getString("strListPicUrl");
                            String strListTitle=jo.getString("strListTitle");
                            String strListIntroduce=jo.getString("strListIntroduce");
                            int intListPosts=jo.getInt("intListPosts");
                            CircleBean circleBean=new CircleBean(strListPicUrl,strListTitle,intListPosts,strListIntroduce);
                            mlist.add(circleBean);
                        }

                        tql.notifyDataSetChanged();

                    }
                    catch (JSONException e) {
                        e.printStackTrace();
                    }

                }

            }


        }






    }

}
