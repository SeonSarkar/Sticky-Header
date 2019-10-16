package com.example.sticky.model;

/**
 * Created by suman.ghimire.
 */
public class MenuItem {

    public static final int HEADER_TYPE = 0;
    public static final int CHILD_TYPE = 1;

    private String itemName;
    private int mType;

    public boolean isHeader;

    public MenuItem(String itemName, int type, boolean isHeader) {
        this.itemName = itemName;
        this.mType = type;
        this.isHeader = isHeader;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getmType() {
        return mType;
    }

    public void setmType(int mType) {
        this.mType = mType;
    }

    public boolean isHeader() {
        return isHeader;
    }

    public void setHeader(boolean header) {
        isHeader = header;
    }
}
