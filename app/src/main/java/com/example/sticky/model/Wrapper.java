package com.example.sticky.model;

/**
 * Created by suman.ghimire.
 */
public class Wrapper<T> {

    public final int viewType;
    public final T data;

    public Wrapper(int viewType, T data) {
        this.viewType = viewType;
        this.data = data;
    }
}
