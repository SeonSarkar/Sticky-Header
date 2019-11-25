package com.seon.hornet.adapters.callback;

import androidx.databinding.ViewDataBinding;

/**
 * Created by Kiran Gyawali on 10/22/2019.
 */

public interface ExpandableRecyclerCallBack<G, C, VBH extends ViewDataBinding,VBC extends ViewDataBinding> {


    void bindGroup(VBH header, G item);

    void bindChild(VBC child, C item);

    void onExpanded(int groupPosition);

    void onCollapsed(int groupPosition);

}