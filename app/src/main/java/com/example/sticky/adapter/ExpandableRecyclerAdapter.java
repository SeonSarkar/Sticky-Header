package com.example.sticky.adapter;

import com.seon.hornet.adapters.adapter.StickyAdapter;
import com.seon.hornet.adapters.callback.StickyRecyclerCallBack;

import java.util.List;

/**
 * Created by suman.ghimire.
 */
public class ExpandableRecyclerAdapter extends StickyAdapter {

    /* private List<StickyItem<H, C>> originalItems;*/

    public ExpandableRecyclerAdapter(List listMenuItems, int headerLayout, int childLayout, StickyRecyclerCallBack callbackInterface) {
        super(listMenuItems, headerLayout, childLayout, callbackInterface);
    }


}
