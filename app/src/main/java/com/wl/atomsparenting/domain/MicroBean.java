package com.wl.atomsparenting.domain;

/**
 * Created by le on 2017/4/26.
 */

public class MicroBean {
    String strRollPicUrl;
    String strRollJumpUrl;
    String strListPicUrl;
    String strListTitle;
    String strDate;
    int intPrice;
    int intAssess;

    public String getStrRollPicUrl() {
        return strRollPicUrl;
    }

    public void setStrRollPicUrl(String strRollPicUrl) {
        this.strRollPicUrl = strRollPicUrl;
    }

    public String getStrRollJumpUrl() {
        return strRollJumpUrl;
    }

    public void setStrRollJumpUrl(String strRollJumpUrl) {
        this.strRollJumpUrl = strRollJumpUrl;
    }

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

    public String getStrDate() {
        return strDate;
    }

    public void setStrDate(String strDate) {
        this.strDate = strDate;
    }

    public int getIntPrice() {
        return intPrice;
    }

    public void setIntPrice(int intPrice) {
        this.intPrice = intPrice;
    }

    public int getIntAssess() {
        return intAssess;
    }

    public void setIntAssess(int intAssess) {
        this.intAssess = intAssess;
    }

    public MicroBean(String strRollPicUrl, String strRollJumpUrl, String strListPicUrl, String strListTitle, String strDate, int intPrice, int intAssess) {

        this.strRollPicUrl = strRollPicUrl;
        this.strRollJumpUrl = strRollJumpUrl;
        this.strListPicUrl = strListPicUrl;
        this.strListTitle = strListTitle;
        this.strDate = strDate;
        this.intPrice = intPrice;
        this.intAssess = intAssess;
    }
}
