package com.example.sticky.adapter;

import androidx.databinding.ViewDataBinding;

import com.seon.hornet.adapters.adapter.StickyAdapter;
import com.seon.hornet.adapters.callback.StickyRecyclerCallBack;

import java.util.List;

/**
 * Created by suman.ghimire.
 */
public class ExpandableRecyclerAdapter<H, C, VBH extends ViewDataBinding, VBC extends ViewDataBinding> extends StickyAdapter {


    public ExpandableRecyclerAdapter(List listMenuItems, int headerLayout, int childLayout, StickyRecyclerCallBack callbackInterface) {
        super(listMenuItems, headerLayout, childLayout, callbackInterface);
    }

}
