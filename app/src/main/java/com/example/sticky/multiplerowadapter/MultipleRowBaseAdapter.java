package com.example.sticky.multiplerowadapter;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sticky.model.Wrapper;

import java.util.List;

/**
 * Created by suman.ghimire.
 */
public class MultipleRowBaseAdapter extends RecyclerView.Adapter<MultipleRowBaseAdapter.ViewHolder> {

    private final List<Wrapper<?>> items;

    public MultipleRowBaseAdapter(List<Wrapper<?>> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public MultipleRowBaseAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return onCreateViewHolder(parent, viewType);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {


    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public int getItemViewType(int position) {
        return items.get(position).viewType;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
