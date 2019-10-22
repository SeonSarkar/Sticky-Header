package com.example.sticky.adapter;

import android.databinding.ViewDataBinding;

/**
 * Created by Kiran Gyawali on 10/22/2019.
 */

public interface RecyclerCallBack<H, C, VBH extends ViewDataBinding,VBC extends ViewDataBinding> {

    void bindHeader(VBH header, H item);

    void bindChild(VBC child, C item);

}