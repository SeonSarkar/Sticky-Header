package com.seon.hornet.adapters.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import com.seon.hornet.adapters.callback.StickyRecyclerCallBack;
import com.seon.hornet.adapters.callback.StickyHeaderCallBack;
import com.seon.hornet.adapters.model.RvItemChild;
import com.seon.hornet.adapters.model.RvItemHeader;
import com.seon.hornet.adapters.model.StickyItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by suman.ghimire.
 */
public class StickyAdapter<H, C, VBH extends ViewDataBinding, VBC extends ViewDataBinding> extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements StickyHeaderCallBack {

    private static final int HEADER_TYPE = 0;
    private static final int CHILD_TYPE = 1;
    private List processedListItems = new ArrayList();
    private int headerLayout;
    private int childLayout;
    private List<StickyItem<H, C>> originalItems;
    private StickyRecyclerCallBack<H, C, VBH, VBC> recyclerCallBack;

    public StickyAdapter(List<StickyItem<H, C>> listMenuItems, @LayoutRes int headerLayout, @LayoutRes int childLayout, StickyRecyclerCallBack<H, C, VBH, VBC> callbackInterface) {
        this.recyclerCallBack = callbackInterface;
        this.headerLayout = headerLayout;
        this.childLayout = childLayout;
        originalItems = listMenuItems;
        processList();
    }

    private void processList() {
        for (int k = 0; k < originalItems.size(); k++) {
            processedListItems.add(new RvItemHeader<>(originalItems.get(k).getHeader(),k));
            for (int i = 0; i < originalItems.get(k).getChildList().size(); i++) {
                processedListItems.add(new RvItemChild<>(originalItems.get(k).getChildList().get(i), k, i));
            }
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context mContext = parent.getContext();
        switch (viewType) {
            case HEADER_TYPE:
                return new ViewHolderHeader((LayoutInflater.from(mContext).inflate(headerLayout, parent, false)));
            case CHILD_TYPE:
               return new ViewHolderChild((LayoutInflater.from(mContext).inflate(childLayout, parent, false)));
        }
        return new ViewHolderChild((LayoutInflater.from(mContext).inflate(childLayout, parent, false)));
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        if (processedListItems.get(position) instanceof RvItemHeader) {
            RvItemHeader rvItemHeader = (RvItemHeader) (processedListItems.get(position));
            H header = originalItems.get(rvItemHeader.getHeaderPosition()).getHeader();
            recyclerCallBack.bindHeader(((ViewHolderHeader) holder).headerBinding, header);
        }
        if (processedListItems.get(position) instanceof RvItemChild) {
            RvItemChild rvItemChild= (RvItemChild) (processedListItems.get(position));
            C child = originalItems.get(rvItemChild.getHeaderPosition()).getChildList().get(rvItemChild.getChildPosition());
            recyclerCallBack.bindChild(((ViewHolderChild) holder).childBinding, child);
        }
    }

    @Override
    public void bindHeaderData(View headerView, int headerPosition) {
        RvItemHeader rvItemHeader = (RvItemHeader) (processedListItems.get(headerPosition));
        H header = originalItems.get(rvItemHeader.getHeaderPosition()).getHeader();
        recyclerCallBack.bindHeader(DataBindingUtil.bind(headerView), header);
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
        VBC childBinding;

        ViewHolderChild(View view) {
            super(view);
            childBinding = DataBindingUtil.bind(view);
        }
    }

}
