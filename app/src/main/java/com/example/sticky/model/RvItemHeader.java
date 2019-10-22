package com.example.sticky.model;

/**
 * Created by Kiran Gyawali on 10/22/2019.
 */

public class RvItemHeader<H> extends RecyclerViewItem {

    private H header;

    public RvItemHeader(H header) {
        isHeader = true;
        this.header=header;
    }

    public H getHeader() {
        return header;
    }

    public void setHeader(H header) {
        this.header = header;
    }
}
