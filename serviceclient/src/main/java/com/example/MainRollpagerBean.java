package com.example;

/**
 * Created by le on 2017/4/26.
 */

public class MainRollpagerBean {
    String strPicUrl;
    String strJumpUrl;

    public MainRollpagerBean(String strPicUrl, String strJumpUrl) {
        this.strPicUrl = strPicUrl;
        this.strJumpUrl = strJumpUrl;
    }

    public String getStrPicUrl() {
        return strPicUrl;
    }

    public void setStrPicUrl(String strPicUrl) {
        this.strPicUrl = strPicUrl;
    }

    public String getStrJumpUrl() {
        return strJumpUrl;
    }

    public void setStrJumpUrl(String strJumpUrl) {
        this.strJumpUrl = strJumpUrl;
    }
}
