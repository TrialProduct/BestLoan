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

/**
 * Created by le on 2017/4/17.
 */

public class MainActivityTopticCard extends BaseCard {
    private String path = "content://com.wl.atomsparenting.contentprovider/atomsparentingtable";
    private ContentResolver resolver;


    private CursorListView listview;
    private ArrayList<HotTopticBean> list;
    private HotTopTicAdapter listViewAdapter;
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
        listview = (CursorListView) mView.findViewById(R.id.main_toptic_listview);
        list = new ArrayList<>();
        listViewAdapter = new HotTopTicAdapter(list, mContext);
        listview.setAdapter(listViewAdapter);
    }

    @Override
    public void bindBean(BaseBean baseBean) {
//        RequestQueue mQueue = Volley.newRequestQueue(mContext);
//        MyStringRequest stringRequest = new MyStringRequest("http://192.168.23.1:8889/HotTopticBean",//"http://169.254.214.59:8889",
//                new Response.Listener<String>() {
//                    @Override
//                    public void onResponse(String response) {
//                        Log.e("MainActivityTopticCard",response);
//
//                        try {
//                            list.clear();
//                            JSONArray jsonArray = new JSONArray(response);
//                            for (int i = 0; i < jsonArray.length(); i++) {
//                                JSONObject jo=jsonArray.getJSONObject(i);
//                                String strBackPicUrl=jo.getString("strBackPicUrl");
//                                String strIntroduce=jo.getString("strIntroduce");
//                                int intAssess=jo.getInt("intAssess");
//                                int intLike=jo.getInt("intLike");
//                                Log.e("MainActivityTopticCard",strBackPicUrl);
//                                HotTopticBean hotTopticBean=new HotTopticBean(null,strBackPicUrl,intAssess,intLike,strIntroduce);
//                                list.add(hotTopticBean);
//
//                            }
//                            listViewAdapter.notifyDataSetChanged();
//                            Log.e("MainActivityTopticCard",list.toString());
//                        } catch (JSONException e) {
//                            e.printStackTrace();
//                        }
//
//
//                    }
//
//
//                },
//                new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//                        Log.e("MainActivityTopticCard", "onErrorResponse" + error.getMessage(), error);
//                    }
//                });
//
//        mQueue.add(stringRequest);

        resolver = getContext().getContentResolver();
//        SharedPreferences share = getContext().getSharedPreferences("config5", Context.MODE_PRIVATE + Context.MODE_APPEND);
//
//        boolean b = share.getBoolean("is_first", true);
//        if (b) {
//            RequestQueue mQueue = Volley.newRequestQueue(getContext());
//            MyStringRequest stringRequest = new MyStringRequest("http://169.254.214.59:8889/HotTopticBean",//"http://169.254.214.59:8889",
//                    new Response.Listener<String>() {
//                        @Override
//                        public void onResponse(String response) {
//                            Log.e("HotTopticBean",response);
//
//                            ContentValues contentvalues = new ContentValues();
//                            contentvalues.put(SQLiteColumn.JSONSTRING,response);
//                            contentvalues.put(SQLiteColumn.RECORDTYPE,"HotTopticBean");
//                            resolver.insert(Uri.parse(path),contentvalues);
//                            try {
//                            list.clear();
//                            JSONArray jsonArray = new JSONArray(response);
//                            for (int i = 0; i < jsonArray.length(); i++) {
//                                JSONObject jo=jsonArray.getJSONObject(i);
//                                String strBackPicUrl=jo.getString("strBackPicUrl");
//                                String strIntroduce=jo.getString("strIntroduce");
//                                int intAssess=jo.getInt("intAssess");
//                                int intLike=jo.getInt("intLike");
//                                Log.e("HotTopticBean",strBackPicUrl);
//                                HotTopticBean hotTopticBean=new HotTopticBean(null,strBackPicUrl,intAssess,intLike,strIntroduce);
//                                list.add(hotTopticBean);
//
//                            }
//                            listViewAdapter.notifyDataSetChanged();
//                            Log.e("HotTopticBean",list.toString());
//                        } catch (JSONException e) {
//                            e.printStackTrace();
//                        }
//                        }
//                    },
//                    new Response.ErrorListener() {
//                        @Override
//                        public void onErrorResponse(VolleyError error) {
//                            Log.e("HotTopticBean", "onErrorResponse" + error.getMessage(), error);
//                        }
//                    });
//            stringRequest.setRetryPolicy(new DefaultRetryPolicy(
//                    (int) MyStringRequest.SOCKET_TIMEOUT, 0,
//                    DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
//            mQueue.add(stringRequest);
        //    share.edit().putBoolean("is_first", false).commit();
//        }else {






        ArrayList<Data> dataArrayList = new ArrayList<>();
        Cursor cursor = resolver.query(Uri.parse(path), null, null, null, null);

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
                        list.clear();
                        JSONArray jsonArray = new JSONArray(dataArrayList.get(j).getJsonString());
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject jo=jsonArray.getJSONObject(i);
                            String strBackPicUrl=jo.getString("strBackPicUrl");
                            String strIntroduce=jo.getString("strIntroduce");
                            int intAssess=jo.getInt("intAssess");
                            int intLike=jo.getInt("intLike");

                            HotTopticBean hotTopticBean=new HotTopticBean(null,strBackPicUrl,intAssess,intLike,strIntroduce);
                            list.add(hotTopticBean);

                        }
                        listViewAdapter.notifyDataSetChanged();

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }

            }


        }





    }


}
