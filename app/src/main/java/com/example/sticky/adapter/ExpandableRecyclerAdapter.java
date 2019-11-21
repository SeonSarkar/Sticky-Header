package com.example.sticky.adapter;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sticky.databinding.RowExpandableChildBinding;
import com.example.sticky.databinding.RowExpandableHeaderBinding;
import com.example.sticky.model.Section;

import java.util.List;

/**
 * Created by suman.ghimire.
 */
public class ExpandableRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private List<Section> sectionList;

    public ExpandableRecyclerAdapter(List<Section> sectionList) {
        this.sectionList = sectionList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return sectionList.size();
    }

    class ViewHolderHeader extends RecyclerView.ViewHolder {
        RowExpandableHeaderBinding rowExpandableHeaderBinding;

        ViewHolderHeader(View view) {
            super(view);
            rowExpandableHeaderBinding = DataBindingUtil.bind(view);
        }
    }

    class ViewHolderChild extends RecyclerView.ViewHolder {
        RowExpandableChildBinding rowExpandableChildBinding;

        ViewHolderChild(View view) {
            super(view);
            rowExpandableChildBinding = DataBindingUtil.bind(view);
        }
    }
}
