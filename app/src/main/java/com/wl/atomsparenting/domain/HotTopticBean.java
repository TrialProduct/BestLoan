package com.wl.atomsparenting.domain;

/**
 * Created by le on 2017/4/26.
 */

public class HotTopticBean {
    String strTitle;
    String strBackPicUrl;
    int intAssess;
    int intLike;
    String strIntroduce;

    public String getStrTitle() {
        return strTitle;
    }

    public void setStrTitle(String strTitle) {
        this.strTitle = strTitle;
    }

    public String getStrBackPicUrl() {
        return strBackPicUrl;
    }

    public void setStrBackPicUrl(String strBackPicUrl) {
        this.strBackPicUrl = strBackPicUrl;
    }

    public int getIntAssess() {
        return intAssess;
    }

    public void setIntAssess(int intAssess) {
        this.intAssess = intAssess;
    }

    public int getIntLike() {
        return intLike;
    }

    public void setIntLike(int intLike) {
        this.intLike = intLike;
    }

    public String getStrIntroduce() {
        return strIntroduce;
    }

    public void setStrIntroduce(String strIntroduce) {
        this.strIntroduce = strIntroduce;
    }

    public HotTopticBean(String strTitle, String strBackPicUrl, int intAssess, int intLike, String strIntroduce) {

        this.strTitle = strTitle;
        this.strBackPicUrl = strBackPicUrl;
        this.intAssess = intAssess;
        this.intLike = intLike;
        this.strIntroduce = strIntroduce;
    }
}
