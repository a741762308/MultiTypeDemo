package com.jsqix.dongqing.multitype.data.bean;

import java.util.List;

/**
 * Created by dongqing on 2017/2/10.
 */

public class RecentBean {
    private HeaderBean headerBean;
    private List<ImgDataBean> list;

    public HeaderBean getHeaderBean() {
        return headerBean;
    }

    public void setHeaderBean(HeaderBean headerBean) {
        this.headerBean = headerBean;
    }

    public List<ImgDataBean> getList() {
        return list;
    }

    public void setList(List<ImgDataBean> list) {
        this.list = list;
    }
}
