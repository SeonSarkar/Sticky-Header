package com.seon.hornet.adapters.model;

/**
 * Created by Kiran Gyawali on 10/22/2019.
 */

public class RvItemHeader<H> {

    private H header;
    private int headerPosition;
    private boolean expanded;

    public RvItemHeader(H header, int headerPosition) {
        this.headerPosition = headerPosition;
        this.header = header;
    }

    public boolean isExpanded() {
        return expanded;
    }

    public void setExpanded(boolean expanded) {
        this.expanded = expanded;
    }

    public int getHeaderPosition() {
        return headerPosition;
    }

    public void setHeaderPosition(int headerPosition) {
        this.headerPosition = headerPosition;
    }

    public H getHeader() {
        return header;
    }

    public void setHeader(H header) {
        this.header = header;
    }
}
