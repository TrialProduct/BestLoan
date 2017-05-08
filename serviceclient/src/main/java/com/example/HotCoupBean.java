package com.example;

/**
 * Created by le on 2017/4/26.
 */

public class HotCoupBean {
    String strPicUrl;
    String strTitle;
    String strAuthor;
    int intLike;

    public String getStrPicUrl() {
        return strPicUrl;
    }

    public void setStrPicUrl(String strPicUrl) {
        this.strPicUrl = strPicUrl;
    }

    public String getStrTitle() {
        return strTitle;
    }

    public void setStrTitle(String strTitle) {
        this.strTitle = strTitle;
    }

    public String getStrAuthor() {
        return strAuthor;
    }

    public void setStrAuthor(String strAuthor) {
        this.strAuthor = strAuthor;
    }

    public int getIntLike() {
        return intLike;
    }

    public void setIntLike(int intLike) {
        this.intLike = intLike;
    }

    public HotCoupBean(String strPicUrl, String strTitle, String strAuthor, int intLike) {

        this.strPicUrl = strPicUrl;
        this.strTitle = strTitle;
        this.strAuthor = strAuthor;
        this.intLike = intLike;
    }
}
