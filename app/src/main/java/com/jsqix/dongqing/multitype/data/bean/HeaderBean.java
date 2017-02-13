package com.jsqix.dongqing.multitype.data.bean;

/**
 * Created by dongqing on 2017/2/10.
 */

public class HeaderBean {
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    private String title;

    public HeaderBean(String title) {
        this.title = title;
    }
}
