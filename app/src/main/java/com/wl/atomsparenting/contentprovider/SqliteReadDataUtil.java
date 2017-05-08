package com.wl.atomsparenting.contentprovider;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;

import java.util.ArrayList;

/**
 * Created by le on 2017/5/2.
 */

public class SqliteReadDataUtil {
    public static String path = "content://com.wl.atomsparenting.contentprovider/atomsparentingtable";
    public static ArrayList<Data> dataArrayList;
    public ArrayList<Data> dataArrayList1;

    public static String getSqliteData(String RecordType, ContentResolver resolver){
        dataArrayList = new ArrayList<>();
        Cursor cursor = resolver.query(Uri.parse(path),null,null,null,null);

        if (cursor!=null) {
            while (cursor.moveToNext()){
                String recordType = cursor.getString(cursor.getColumnIndex(SQLiteColumn.RECORDTYPE));
                String jsonString = cursor.getString(cursor.getColumnIndex(SQLiteColumn.JSONSTRING));
                Data data = new Data(recordType,jsonString);
                dataArrayList.add(data);
                if (cursor == null) {
                    break;
                }
            }

            for (int i = 0; i < dataArrayList.size(); i++) {

                if (RecordType.equals(dataArrayList.get(i).getRecordType())) {

                    return dataArrayList.get(i).getJsonString();
                }

            }
        }

        return null;
    }

    public   String getSqliteType(String RecordType,ContentResolver resolver){
        dataArrayList1 = new ArrayList<>();
        Cursor cursor = resolver.query(Uri.parse(path),null,null,null,null);
        if (cursor!=null) {
            while (cursor.moveToNext()){
                String recordType = cursor.getString(cursor.getColumnIndex(SQLiteColumn.RECORDTYPE));
                String jsonString = cursor.getString(cursor.getColumnIndex(SQLiteColumn.JSONSTRING));

                Data data = new Data(recordType,jsonString);
                dataArrayList1.add(data);
            }

            for (int i = 0; i < dataArrayList1.size(); i++) {

                if (RecordType.equals(dataArrayList1.get(i).getRecordType())) {

                    return dataArrayList1.get(i).getRecordType();
                }

            }
        }

        return null;
    }

}
