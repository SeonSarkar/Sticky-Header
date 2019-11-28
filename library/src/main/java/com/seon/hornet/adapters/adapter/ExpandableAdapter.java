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

import com.seon.hornet.adapters.R;
import com.seon.hornet.adapters.callback.ExpandableRecyclerCallBack;
import com.seon.hornet.adapters.model.ExpandableItem;
import com.seon.hornet.adapters.model.RvItemChild;
import com.seon.hornet.adapters.model.RvItemHeader;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by suman.ghimire.
 */
public class ExpandableAdapter<G, C, VBH extends ViewDataBinding, VBC extends ViewDataBinding> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int HEADER_TYPE = 0;
    private static final int CHILD_TYPE = 1;
    private List processedListItems = new ArrayList();
    private int groupLayout;
    private int childLayout;
    private List<ExpandableItem<G, C>> originalItems;
    private ExpandableRecyclerCallBack<G, C, VBH, VBC> recyclerCallBack;

    public ExpandableAdapter(List<ExpandableItem<G, C>> listMenuItems, @LayoutRes int groupLayout, @LayoutRes int childLayout,
                             @NonNull ExpandableRecyclerCallBack<G, C, VBH, VBC> callbackInterface) {
        this.recyclerCallBack = callbackInterface;
        this.groupLayout = groupLayout;
        this.childLayout = childLayout;
        originalItems = listMenuItems;
        processList();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context mContext = parent.getContext();
        switch (viewType) {
            case HEADER_TYPE:
                return new ViewHolderHeader((LayoutInflater.from(mContext).inflate(groupLayout, parent, false)));
            case CHILD_TYPE:
                return new ViewHolderChild((LayoutInflater.from(mContext).inflate(childLayout, parent, false)));
        }
        return new EmptyViewHolder((LayoutInflater.from(mContext).inflate(R.layout.empty_view, parent, false)));
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        if (processedListItems.get(position) instanceof RvItemHeader) {
            RvItemHeader rvItemHeader = (RvItemHeader) (processedListItems.get(position));
            G group = originalItems.get(rvItemHeader.getHeaderPosition()).getGroup();
            recyclerCallBack.bindGroup(((ViewHolderHeader) holder).headerBinding, group, rvItemHeader.getHeaderPosition());


            ((ViewHolderHeader) holder).headerBinding.getRoot().setOnClickListener(v -> {
                if (rvItemHeader.isExpanded()) {
                    collapseGroup(rvItemHeader.getHeaderPosition(), position);
                } else {
                    expandGroup(rvItemHeader.getHeaderPosition(), position);
                }
                notifyDataSetChanged();
            });
        }

        if (processedListItems.get(position) instanceof RvItemChild) {
            RvItemChild rvItemChild = (RvItemChild) (processedListItems.get(position));
            if (rvItemChild.isVisible()) {
                C child = originalItems.get(rvItemChild.getHeaderPosition()).getChildList().get(rvItemChild.getChildPosition());
                recyclerCallBack.bindChild(((ViewHolderChild) holder).childBinding, child,rvItemChild.getHeaderPosition(),rvItemChild.getChildPosition());
            }
        }
    }

    private void collapseGroup(int groupPosition, int currentPosition) {
        recyclerCallBack.onCollapsed(groupPosition);
        ((RvItemHeader) (processedListItems.get(currentPosition))).setExpanded(false);
        collapseExpandGroup(false, groupPosition);
    }

    private void expandGroup(int groupPosition, int currentPosition) {
        recyclerCallBack.onExpanded(groupPosition);
        ((RvItemHeader) (processedListItems.get(currentPosition))).setExpanded(true);
        collapseExpandGroup(true, groupPosition);

    }

    private void collapseExpandGroup(boolean expand, int groupPosition) {
        for (int i = 0; i < processedListItems.size(); i++) {
            if (processedListItems.get(i) instanceof RvItemChild
                    && ((RvItemChild) processedListItems.get(i)).getHeaderPosition() == groupPosition) {
                ((RvItemChild) processedListItems.get(i)).setVisible(expand);
            }
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (processedListItems != null) {
            if (processedListItems.get(position) instanceof RvItemHeader) {
                return HEADER_TYPE;
            }
            if (processedListItems.get(position) instanceof RvItemChild) {
                if (((RvItemChild) processedListItems.get(position)).isVisible()) {
                    return CHILD_TYPE;
                }
            }
        }
        return -1;
    }

    @Override
    public int getItemCount() {
        return processedListItems.size();
    }

    private void processList() {
        for (int k = 0; k < originalItems.size(); k++) {
            processedListItems.add(new RvItemHeader<>(originalItems.get(k).getGroup(), k));
            for (int i = 0; i < originalItems.get(k).getChildList().size(); i++) {
                processedListItems.add(new RvItemChild<>(originalItems.get(k).getChildList().get(i), k, i));
            }
        }
    }

    public void refreshData(List<ExpandableItem<G, C>> refreshedItemsList) {
        this.originalItems = refreshedItemsList;
        processList();
        notifyDataSetChanged();
    }

    public void appendData(List<ExpandableItem<G, C>> listItems) {
        this.originalItems.addAll(listItems);
        processList();
        notifyDataSetChanged();
    }

    public G getGroup(int groupPosition) {
        return originalItems.get(groupPosition).getGroup();
    }

    public C getChild(int headerPosition, int childPosition) {
        return originalItems.get(headerPosition).getChildList().get(childPosition);
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

    class EmptyViewHolder extends RecyclerView.ViewHolder {
        EmptyViewHolder(View view) {
            super(view);
        }
    }

}
