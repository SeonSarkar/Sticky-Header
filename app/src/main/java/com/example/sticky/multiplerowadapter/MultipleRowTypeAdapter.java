package com.example.sticky.multiplerowadapter;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

/**
 * Created by suman.ghimire.
 */


public class MultipleRowTypeAdapter<VBN extends ViewDataBinding> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<String> listDataString;

    public MultipleRowTypeAdapter(List<String> listDataString) {
        this.listDataString = listDataString;
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
        return listDataString.size();
    }

    class ViewHolderNType extends RecyclerView.ViewHolder {
        VBN viewNBinding;

        ViewHolderNType(View view) {
            super(view);
            viewNBinding = DataBindingUtil.bind(view);
        }
    }




}
