package com.seon.hornet.adapters.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import com.seon.hornet.adapters.callback.GenericRecyclerCallBack;

import java.util.List;

/**
 * Created by Kiran Gyawali on 10/22/2019.
 */

public class GenericAdapter<T, VM extends ViewDataBinding> extends RecyclerView.Adapter<GenericAdapter.BindingHolder> {

    private List<T> listItems;
    private int layoutId;
    private GenericRecyclerCallBack<VM, T> bindingInterface;

    public GenericAdapter(List<T> listItems, int layoutId, GenericRecyclerCallBack<VM, T> bindingInterface) {
        this.listItems = listItems;
        this.layoutId = layoutId;
        this.bindingInterface = bindingInterface;
    }

    @NonNull
    @Override
    public GenericAdapter.BindingHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(layoutId, parent, false);
        return new BindingHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull GenericAdapter.BindingHolder holder, int position) {
        T item = listItems.get(holder.getAdapterPosition());
        bindingInterface.bindData((VM) holder.binding, item, listItems, position);
    }

    @Override
    public int getItemCount() {
        try {
            return listItems.size();
        } catch (Exception e) {
            return 0;
        }
    }

    public void refreshData(List<T> refreshedListItems) {
        this.listItems = refreshedListItems;
        notifyDataSetChanged();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    class BindingHolder extends RecyclerView.ViewHolder {
        VM binding;

        BindingHolder(View view) {
            super(view);
            binding = DataBindingUtil.bind(view);
        }
    }

}