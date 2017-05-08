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
import com.wl.atomsparenting.adapter.GridGoodTrickbaseadapter;
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
    private String path = "content://com.wl.atomsparenting.contentprovider/atomsparentingtable";
    private ContentResolver resolver;

    private ArrayList<GriddoGoodTrick> listgoodtrick;
    private HeaderGridView recyclerview;
    private GridGoodTrickbaseadapter gridbaseadapter;

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
        recyclerview = (HeaderGridView) mView.findViewById(R.id.main_goodtrick_recyclerview);
        recyclerview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });
        listgoodtrick = new ArrayList<>();
        gridbaseadapter = new GridGoodTrickbaseadapter(listgoodtrick, mContext);
        recyclerview.setAdapter(gridbaseadapter);
    }

    @Override
    public void bindBean(BaseBean baseBean) {
        initrecyclerview();
    }

    private void initrecyclerview() {


        shujuyuan();
    }

    private void shujuyuan() {
//        RequestQueue mQueue = Volley.newRequestQueue(getContext());
//        MyStringRequest stringRequest = new MyStringRequest("http://192.168.23.1:8889/HotCoupBean",//"http://169.254.214.59:8889",
//                new Response.Listener<String>() {
//                    @Override
//                    public void onResponse(String response) {
//                        Log.e("GridView2Card",response);
//                        try {
//                            listgoodtrick.clear();
//                            JSONArray jsonArray=new JSONArray(response);
//                            for (int i = 0; i < jsonArray.length(); i++) {
//                                JSONObject jo=jsonArray.getJSONObject(i);
//                                String strPicUrl=jo.getString("strPicUrl");
//                                String strTitle=jo.getString("strTitle");
//                                String strAuthor=jo.getString("strAuthor");
//                                int intLike=jo.getInt("intLike");
//                                GriddoGoodTrick griddomaiozhao=new GriddoGoodTrick(strPicUrl,strTitle,intLike,strAuthor);
//                                listgoodtrick.add(griddomaiozhao);
//
//                            }
//                            gridbaseadapter.notifyDataSetChanged();
//                        }
//                        catch (JSONException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                },
//                new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//                        Log.e("GridView2Card", "onErrorResponse" + error.getMessage(), error);
//                    }
//                });
//
//        mQueue.add(stringRequest);

        resolver = getContext().getContentResolver();
//        SharedPreferences share = getContext().getSharedPreferences("config1", Context.MODE_PRIVATE + Context.MODE_APPEND);
//
//        boolean b = share.getBoolean("is_first", true);
//        if (b) {
//            RequestQueue mQueue = Volley.newRequestQueue(getContext());
//            MyStringRequest stringRequest = new MyStringRequest("http://169.254.214.59:8889/HotCoupBean",//"http://169.254.214.59:8889",
//                    new Response.Listener<String>() {
//                        @Override
//                        public void onResponse(String response) {
//                            Log.e("GridView2Card",response);
//
//                            ContentValues contentvalues = new ContentValues();
//                            contentvalues.put(SQLiteColumn.JSONSTRING,response);
//                            contentvalues.put(SQLiteColumn.RECORDTYPE,"HotCoupBean");
//                            resolver.insert(Uri.parse(path),contentvalues);
//                            try {
//                                listgoodtrick.clear();
//                                JSONArray jsonArray = new JSONArray(response);
//                                for (int i = 0; i < jsonArray.length(); i++) {
//                                    JSONObject jo = jsonArray.getJSONObject(i);
//                                    String strPicUrl = jo.getString("strPicUrl");
//                                    String strTitle = jo.getString("strTitle");
//                                    String strAuthor = jo.getString("strAuthor");
//                                    int intLike = jo.getInt("intLike");
//                                    GriddoGoodTrick griddomaiozhao = new GriddoGoodTrick(strPicUrl, strTitle, intLike, strAuthor);
//                                    listgoodtrick.add(griddomaiozhao);
//
//                                }
//                                gridbaseadapter.notifyDataSetChanged();
//                            } catch (JSONException e) {
//                                e.printStackTrace();
//                            }
//                        }
//                    },
//                    new Response.ErrorListener() {
//                        @Override
//                        public void onErrorResponse(VolleyError error) {
//                            Log.e("GridView2Card", "onErrorResponse" + error.getMessage(), error);
//                        }
//                    });
//            stringRequest.setRetryPolicy(new DefaultRetryPolicy(
//                    (int) MyStringRequest.SOCKET_TIMEOUT, 0,
//                    DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
//
//            mQueue.add(stringRequest);
//      //      share.edit().putBoolean("is_first", false).commit();
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

                if (dataArrayList.get(j).getRecordType().equals("hotCoupBeen")) {

                    try {
                        listgoodtrick.clear();
                        JSONArray jsonArray = new JSONArray(dataArrayList.get(j).getJsonString());
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject jo = jsonArray.getJSONObject(i);
                            String strPicUrl = jo.getString("strPicUrl");
                            String strTitle = jo.getString("strTitle");
                            String strAuthor = jo.getString("strAuthor");
                            int intLike = jo.getInt("intLike");
                            GriddoGoodTrick griddomaiozhao = new GriddoGoodTrick(strPicUrl, strTitle, intLike, strAuthor);
                            listgoodtrick.add(griddomaiozhao);

                        }
                        gridbaseadapter.notifyDataSetChanged();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

            }


//        }

        }
    }
}
