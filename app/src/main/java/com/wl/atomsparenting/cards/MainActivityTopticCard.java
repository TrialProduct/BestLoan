package com.wl.atomsparenting.cards;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

import com.wl.atomsparenting.R;
import com.wl.atomsparenting.adapter.HotTopTicAdapter;
import com.wl.atomsparenting.beans.BaseBean;
import com.wl.atomsparenting.contentprovider.Data;
import com.wl.atomsparenting.contentprovider.SQLiteColumn;
import com.wl.atomsparenting.domain.HotTopticBean;
import com.wl.atomsparenting.views.CursorListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import static android.R.id.list;
import static com.wl.atomsparenting.contentprovider.SqliteReadDataUtil.path;

/**
 * Created by le on 2017/4/17.
 */

public class MainActivityTopticCard extends BaseCard {
    private String mpath = "content://com.wl.atomsparenting.contentprovider/atomsparentingtable";
    private ContentResolver mresolver;


<<<<<<< HEAD
    private CursorListView listview;
    private ArrayList<HotTopticBean> list;
    private HotTopTicAdapter listViewAdapter;
=======
    private CursorListView mlistview;
    private ArrayList<HotTopticBean> mlist;
    private ListViewAdapter mlistViewAdapter;
>>>>>>> 0644114a8c4e536627331d3955b94957889c3856
    public MainActivityTopticCard(@NonNull Context context) {
        super(context);
    }

    public MainActivityTopticCard(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected int getFindView() {
        return R.layout.mainactivity_toptic;
    }

    @Override
    protected void getMaterial() {
<<<<<<< HEAD
        listview = (CursorListView) mView.findViewById(R.id.main_toptic_listview);
        list = new ArrayList<>();
        listViewAdapter = new HotTopTicAdapter(list, mContext);
        listview.setAdapter(listViewAdapter);
=======
        mlistview = (CursorListView) mView.findViewById(R.id.main_toptic_listview);
        mlist = new ArrayList<>();
        mlistViewAdapter = new ListViewAdapter(mlist, mContext);
        mlistview.setAdapter(mlistViewAdapter);
>>>>>>> 0644114a8c4e536627331d3955b94957889c3856
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

                if (dataArrayList.get(j).getRecordType().equals("hotTopticBeen")) {

                    try {
                        mlist.clear();
                        JSONArray jsonArray = new JSONArray(dataArrayList.get(j).getJsonString());
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject jo=jsonArray.getJSONObject(i);
                            String strBackPicUrl=jo.getString("strBackPicUrl");
                            String strIntroduce=jo.getString("strIntroduce");
                            int intAssess=jo.getInt("intAssess");
                            int intLike=jo.getInt("intLike");

                            HotTopticBean hotTopticBean=new HotTopticBean(null,strBackPicUrl,intAssess,intLike,strIntroduce);
                            mlist.add(hotTopticBean);

                        }
                        mlistViewAdapter.notifyDataSetChanged();

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }

            }


        }





    }


}
