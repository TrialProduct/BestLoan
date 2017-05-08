package com.wl.atomsparenting.domain;

/**
 * Created by le on 2017/4/26.
 */

public class CircleBean {
    String strListPicUrl;
    String strListTitle;

    int intListPosts;
    String strListIntroduce;


    public String getStrListPicUrl() {
        return strListPicUrl;
    }

    public void setStrListPicUrl(String strListPicUrl) {
        this.strListPicUrl = strListPicUrl;
    }

    public String getStrListTitle() {
        return strListTitle;
    }

    public void setStrListTitle(String strListTitle) {
        this.strListTitle = strListTitle;
    }


    public int getIntListPosts() {
        return intListPosts;
    }

    public void setIntListPosts(int intListPosts) {
        this.intListPosts = intListPosts;
    }

    public String getStrListIntroduce() {
        return strListIntroduce;
    }

    public void setStrListIntroduce(String strListIntroduce) {
        this.strListIntroduce = strListIntroduce;
    }

    public CircleBean(String strListPicUrl, String strListTitle,  int intListPosts, String strListIntroduce) {

        this.strListPicUrl = strListPicUrl;
        this.strListTitle = strListTitle;

        this.intListPosts = intListPosts;
        this.strListIntroduce = strListIntroduce;

    }
}
