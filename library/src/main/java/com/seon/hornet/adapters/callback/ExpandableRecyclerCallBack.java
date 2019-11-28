package com.seon.hornet.adapters.callback;

import androidx.databinding.ViewDataBinding;

/**
 * Created by Kiran Gyawali on 10/22/2019.
 */

public interface ExpandableRecyclerCallBack<G, C, VBH extends ViewDataBinding,VBC extends ViewDataBinding> {


    void bindGroup(VBH header, G item, int groupPosition);

    void bindChild(VBC child, C item, int groupPosition, int childPosition);

    void onExpanded(int groupPosition);

    void onCollapsed(int groupPosition);

}