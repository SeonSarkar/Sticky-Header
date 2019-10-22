package com.seon.hornet.adapters.callback;

import androidx.databinding.ViewDataBinding;

import java.util.List;

/**
 * Created by Kiran Gyawali on 10/22/2019.
 */

public interface GenericRecyclerCallBack<VB extends ViewDataBinding, T> {

    void bindData(VB binding, T item, List<T> allItem, int itemPosition);

}
