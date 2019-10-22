package com.example.sticky.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.LayoutRes;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sticky.itemdecoration.ItemDecoration;
import com.example.sticky.model.RvItemChild;
import com.example.sticky.model.RvItemHeader;
import com.example.sticky.model.StickeyItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by suman.ghimire.
 */
public class StickyAdapter<H, C, VBH extends ViewDataBinding, VBC extends ViewDataBinding> extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements ItemDecoration.StickyHeaderInterface {

    private static final int HEADER_TYPE = 0;
    private static final int CHILD_TYPE = 1;
    private List processedListItems = new ArrayList();
    private int headerLayout;
    private int childLayout;
    private RecyclerCallBack<H, C, VBH, VBC> recyclerCallBack;

    public StickyAdapter(List<StickeyItem<H, C>> listMenuItems, @LayoutRes int headerLayout, @LayoutRes int childLayout, RecyclerCallBack<H, C, VBH, VBC> callbackInterface) {
        this.recyclerCallBack = callbackInterface;
        this.headerLayout = headerLayout;
        this.childLayout = childLayout;
        processList(listMenuItems);
    }

    private void processList(List<StickeyItem<H, C>> listMenuItems) {
        for (int k = 0; k < listMenuItems.size(); k++) {
            processedListItems.add(new RvItemHeader<>(listMenuItems.get(k).getHeader()));
            for (int i = 0; i < listMenuItems.get(k).getChildList().size(); i++) {
                processedListItems.add(new RvItemChild<>(listMenuItems.get(k).getChildList().get(i), k));
            }
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context mContext = parent.getContext();
        switch (viewType) {
            case HEADER_TYPE:
                View headerView = (LayoutInflater.from(mContext).inflate(headerLayout, parent, false));
                return new ViewHolderHeader(headerView);

            case CHILD_TYPE:
                View childView = (LayoutInflater.from(mContext).inflate(childLayout, parent, false));
                return new ViewHolderChild(childView);
        }
        return null;
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        if (processedListItems.get(position) instanceof RvItemHeader) {
            H header = (H) processedListItems.get(position);
            recyclerCallBack.bindHeader(((ViewHolderHeader) holder).headerBinding, header);
        }
        if (processedListItems.get(position) instanceof RvItemChild) {
            C child = (C) processedListItems.get(position);
            recyclerCallBack.bindChild(((ViewHolderChild) holder).headerBinding, child);
        }
    }

    @Override
    public void bindHeaderData(View header, int headerPosition) {
        recyclerCallBack.bindHeader((VBH) DataBindingUtil.bind(header), (H) processedListItems.get(headerPosition));
    }

    @Override
    public int getItemViewType(int position) {
        if (processedListItems != null) {
            if (processedListItems.get(position) instanceof RvItemHeader) {
                return HEADER_TYPE;
            }
            if (processedListItems.get(position) instanceof RvItemChild) {
                return CHILD_TYPE;
            }
        }
        return -1;
    }

    @Override
    public int getItemCount() {
        return processedListItems.size();
    }

    @Override
    public int getHeaderLayout(int headerPosition) {
        return headerLayout;
    }


    @Override
    public int getHeaderPositionForItem(int itemPosition) {
        int headerPosition = 0;
        do {
            if (this.isHeader(itemPosition)) {
                headerPosition = itemPosition;
                break;
            }
            itemPosition -= 1;
        } while (itemPosition >= 0);
        return headerPosition;
    }

    @Override
    public boolean isHeader(int itemPosition) {
        return getItemViewType(itemPosition) == HEADER_TYPE;
    }

    class ViewHolderHeader extends RecyclerView.ViewHolder {
        VBH headerBinding;

        ViewHolderHeader(View view) {
            super(view);
            headerBinding = DataBindingUtil.bind(view);
        }
    }

    class ViewHolderChild extends RecyclerView.ViewHolder {
        VBC headerBinding;

        ViewHolderChild(View view) {
            super(view);
            headerBinding = DataBindingUtil.bind(view);
        }
    }

}
