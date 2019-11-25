package com.seon.hornet.adapters.model;

import java.util.List;

/**
 * Created by Kiran Gyawali on 25/11/2019.
 */
public class ExpandableItem<G, C> {

    private List<C> childList;
    private G group;

    public ExpandableItem() {
    }

    public ExpandableItem(List<C> childList, G group) {
        this.childList = childList;
        this.group= group;
    }

    public List<C> getChildList() {
        return childList;
    }

    public void setChildList(List<C> childList) {
        this.childList = childList;
    }

    public G getGroup() {
        return group;
    }

    public void setGroup(G group) {
        this.group= group;
    }
}


