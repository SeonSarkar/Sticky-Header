package com.example.sticky.model;

import java.util.List;

/**
 * Created by suman.ghimire.
 */
public class Section {

    private String header;
    private List<String> itemList;

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public List<String> getItemList() {
        return itemList;
    }

    public void setItemList(List<String> itemList) {
        this.itemList = itemList;
    }
}
