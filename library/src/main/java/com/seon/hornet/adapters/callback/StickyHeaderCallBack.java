package com.seon.hornet.adapters.callback;

import android.view.View;

/**
 * Created by Kiran Gyawali on 10/22/2019.
 */
public interface StickyHeaderCallBack {

    int getHeaderPositionForItem(int itemPosition);

    int getHeaderLayout(int headerPosition);

    void bindHeaderData(View header, int headerPosition);

    boolean isHeader(int itemPosition);

}
