package com.seon.hornet.stickyheader.model;

/**
 * Created by Kiran Gyawali on 10/22/2019.
 */

public class RvItemChild<C> extends RecyclerViewItem {

    private C child;
    private int headerPosition;
    private int childPosition;

    public RvItemChild(C child, int headerPosition, int childPosition) {
        isHeader = false;
        this.headerPosition = headerPosition;
        this.childPosition = childPosition;
        this.child = child;
    }

    public int getChildPosition() {
        return childPosition;
    }

    public void setChildPosition(int childPosition) {
        this.childPosition = childPosition;
    }

    public int getHeaderPosition() {
        return headerPosition;
    }

    public void setHeaderPosition(int headerPosition) {
        this.headerPosition = headerPosition;
    }

    public C getChild() {
        return child;
    }

    public void setChild(C child) {
        this.child = child;
    }
}
