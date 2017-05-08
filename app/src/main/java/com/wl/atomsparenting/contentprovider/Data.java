package com.wl.atomsparenting.contentprovider;

/**
 * Created by le on 2017/4/28.
 */

public class Data {
    private String recordType;
    private String JsonString;

    public Data(String recordType, String jsonString) {
        this.recordType = recordType;
        JsonString = jsonString;
    }

    public Data() {
    }

    public String getRecordType() {
        return recordType;
    }

    public void setRecordType(String recordType) {
        this.recordType = recordType;
    }

    public String getJsonString() {
        return JsonString;
    }

    public void setJsonString(String jsonString) {
        JsonString = jsonString;
    }
}
