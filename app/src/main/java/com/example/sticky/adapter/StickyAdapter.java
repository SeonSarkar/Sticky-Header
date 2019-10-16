package com.example.sticky.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.sticky.R;
import com.example.sticky.databinding.RowListChildItemBinding;
import com.example.sticky.databinding.RowListHeaderItemBinding;
import com.example.sticky.itemdecoration.ItemDecoration;
import com.example.sticky.model.MenuItem;

import java.util.List;

/**
 * Created by suman.ghimire.
 */
public class StickyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements ItemDecoration.StickyHeaderInterface {

    private List<MenuItem> listMenuItems;

    public StickyAdapter(List<MenuItem> listMenuItems) {
        this.listMenuItems = listMenuItems;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        Context mContext = parent.getContext();

        switch (viewType) {
            case MenuItem.HEADER_TYPE:
                RowListHeaderItemBinding rowListHeaderItemBinding = RowListHeaderItemBinding.
                        bind(LayoutInflater.from(mContext).inflate(R.layout.row_list_header_item, parent, false));
                return new ViewHolderHeader(rowListHeaderItemBinding);

            case MenuItem.CHILD_TYPE:
                RowListChildItemBinding rowListChildItemBinding = RowListChildItemBinding
                        .bind(LayoutInflater.from(mContext).inflate(R.layout.row_list_child_item, parent, false));
                return new ViewHolderChild(rowListChildItemBinding);
        }
        return null;
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        MenuItem menuItem = listMenuItems.get(position);

        switch (menuItem.getmType()) {
            case MenuItem.HEADER_TYPE:
                ((ViewHolderHeader) holder).rowListHeaderItemBinding.tvHeaderItem.setText(menuItem.getItemName());
                break;

            case MenuItem.CHILD_TYPE:
                ((ViewHolderChild) holder).rowListChildItemBinding.tvChildItem.setText(menuItem.getItemName());
                break;

            default:
                break;
        }
    }

    public static class ViewHolderHeader extends RecyclerView.ViewHolder {

        private RowListHeaderItemBinding rowListHeaderItemBinding;

        public ViewHolderHeader(RowListHeaderItemBinding rowListHeaderItemBinding) {
            super(rowListHeaderItemBinding.getRoot());
            this.rowListHeaderItemBinding = rowListHeaderItemBinding;
        }
    }


    public static class ViewHolderChild extends RecyclerView.ViewHolder {

        private RowListChildItemBinding rowListChildItemBinding;

        public ViewHolderChild(RowListChildItemBinding rowListChildItemBinding) {
            super(rowListChildItemBinding.getRoot());
            this.rowListChildItemBinding = rowListChildItemBinding;
        }
    }


    @Override
    public int getItemCount() {
        return listMenuItems.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (listMenuItems != null) {
            MenuItem menuItem = listMenuItems.get(position);
            if (menuItem != null) {
                return menuItem.getmType();
            }
        }
        return 0;
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
    public int getHeaderLayout(int headerPosition) {
        return R.layout.row_list_header_item;
    }

    @Override
    public void bindHeaderData(View header, int headerPosition) {
        MenuItem menuItem = listMenuItems.get(headerPosition);

        TextView tvName = header.findViewById(R.id.tvHeaderItem);
        tvName.setText(menuItem.getItemName());
    }

    @Override
    public boolean isHeader(int itemPosition) {
        return listMenuItems.get(itemPosition).isHeader();
    }

}
