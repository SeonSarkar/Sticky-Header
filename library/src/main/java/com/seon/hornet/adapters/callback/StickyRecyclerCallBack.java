package com.seon.hornet.adapters.callback;

import androidx.databinding.ViewDataBinding;

/**
 * Created by Kiran Gyawali on 10/22/2019.
 */

public interface StickyRecyclerCallBack<H, C, VBH extends ViewDataBinding,VBC extends ViewDataBinding> {

    void bindHeader(VBH header, H item);

    void bindChild(VBC child, C item);

}