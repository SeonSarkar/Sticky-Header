package com.seon.hornet.adapters.model;

import java.util.List;

/**
 * Created by Kiran Gyawali on 10/22/2019.
 */

public class StickyItem<H,C> {

    private List<C> childList;
    private H header;

    public StickyItem() {
    }

    public StickyItem(List<C> childList, H header) {
        this.childList = childList;
        this.header = header;
    }

    public List<C> getChildList() {
        return childList;
    }

    public void setChildList(List<C> childList) {
        this.childList = childList;
    }

    public H getHeader() {
        return header;
    }

    public void setHeader(H header) {
        this.header = header;
    }
}
