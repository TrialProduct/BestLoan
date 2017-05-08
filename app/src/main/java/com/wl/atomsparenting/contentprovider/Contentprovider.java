package com.wl.atomsparenting.contentprovider;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Created by le on 2017/5/2.
 */

public class Contentprovider extends ContentProvider{
    private String path = "content://com.wl.atomsparenting.contentprovider/atomsparentingtable";
    private SQLiteDatabase database;

    @Override
    public boolean onCreate() {
        SqliteopenHelper sqliteopenHelper = new SqliteopenHelper(getContext());
        database = sqliteopenHelper.getReadableDatabase();

        return false;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] strings, @Nullable String s, @Nullable String[] strings1, @Nullable String s1) {
        Cursor cursor = database.query(SQLiteColumn.DATA_TABLE,strings,s,strings1,null,null,s1);

        return cursor;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        long u = database.insert(SQLiteColumn.DATA_TABLE,null,contentValues);
        Uri uri1 = ContentUris.withAppendedId(Uri.parse(path),u);
        return uri1;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String s, @Nullable String[] strings) {
        int i = database.delete(SQLiteColumn.DATA_TABLE,s,strings);

        return i;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String s, @Nullable String[] strings) {
        int i = database.update(SQLiteColumn.DATA_TABLE,contentValues,s,strings);
        return i;
    }
}
