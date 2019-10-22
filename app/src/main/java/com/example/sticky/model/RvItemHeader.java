package com.example.sticky.model;

/**
 * Created by Kiran Gyawali on 10/22/2019.
 */

public class RvItemHeader<H> extends RecyclerViewItem {

    private H header;
    private int headerPosition;

    public RvItemHeader(H header, int headerPosition) {
        isHeader = true;
        this.headerPosition = headerPosition;
        this.header=header;
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
