package com.example.sticky.model;

import java.util.List;

/**
 * Created by suman.ghimire.
 */
public class ChildItem {

    private String childName;
    private List<DataItems> itemsList;

    public List<DataItems> getItemsList() {
        return itemsList;
    }

    public void setItemsList(List<DataItems> itemsList) {
        this.itemsList = itemsList;
    }

    public String getChildName() {
        return childName;
    }

    public void setChildName(String childName) {
        this.childName = childName;
    }
}
