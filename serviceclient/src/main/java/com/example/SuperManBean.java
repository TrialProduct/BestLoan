package com.example;

/**
 * Created by le on 2017/4/26.
 */

public class SuperManBean {
    String strBackPicUrl;
    String strHeadPicUrl;
    String strName;
    int intLevel;
    String strIntroduce;

    public String getStrBackPicUrl() {
        return strBackPicUrl;
    }

    public void setStrBackPicUrl(String strBackPicUrl) {
        this.strBackPicUrl = strBackPicUrl;
    }

    public String getStrHeadPicUrl() {
        return strHeadPicUrl;
    }

    public void setStrHeadPicUrl(String strHeadPicUrl) {
        this.strHeadPicUrl = strHeadPicUrl;
    }

    public String getStrName() {
        return strName;
    }

    public void setStrName(String strName) {
        this.strName = strName;
    }

    public int getIntLevel() {
        return intLevel;
    }

    public void setIntLevel(int intLevel) {
        this.intLevel = intLevel;
    }

    public String getStrIntroduce() {
        return strIntroduce;
    }

    public void setStrIntroduce(String strIntroduce) {
        this.strIntroduce = strIntroduce;
    }

    public SuperManBean(String strBackPicUrl, String strHeadPicUrl, String strName, int intLevel, String strIntroduce) {

        this.strBackPicUrl = strBackPicUrl;
        this.strHeadPicUrl = strHeadPicUrl;
        this.strName = strName;
        this.intLevel = intLevel;
        this.strIntroduce = strIntroduce;
    }

    public SuperManBean() {
    }
}
