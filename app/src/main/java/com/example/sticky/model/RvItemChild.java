package com.example.sticky.model;

/**
 * Created by Kiran Gyawali on 10/22/2019.
 */

public class RvItemChild<C> extends RecyclerViewItem {

    private C child;
    private int headerPosition;

    public RvItemChild(C child, int headerPosition) {
        isHeader=false;
        this.headerPosition=headerPosition;
        this.child=child;
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
