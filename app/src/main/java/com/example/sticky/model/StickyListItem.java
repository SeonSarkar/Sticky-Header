package com.example.sticky.model;

import java.util.List;

/**
 * Created by suman.ghimire.
 */
public class StickyListItem<T> {

    private List<T> child;
    private String title;

    public StickyListItem() {
    }

    public StickyListItem( String title,List<T> child) {
        this.child = child;
        this.title = title;
    }

    public List<T> getChild() {
        return child;
    }

    public void setChild(List<T> child) {
        this.child = child;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
