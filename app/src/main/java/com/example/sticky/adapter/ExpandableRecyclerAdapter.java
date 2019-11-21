package com.example.sticky.adapter;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sticky.model.HeaderItem;

import java.util.List;

/**
 * Created by suman.ghimire.
 */
public class ExpandableRecyclerAdapter  extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    List<HeaderItem> headerItems;


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
        return 0;
    }
}
