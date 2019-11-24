package com.example.sticky;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.sticky.databinding.ActivityRecyclerViewBinding;
import com.example.sticky.databinding.RowListChildItemBinding;
import com.seon.hornet.adapters.adapter.GenericAdapter;
import com.seon.hornet.adapters.callback.GenericRecyclerCallBack;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewActivity extends AppCompatActivity {

    ActivityRecyclerViewBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_recycler_view);
        List<String> stringList = new ArrayList<>();

        for (int i = 0; i < 50; i++) {
            stringList.add("item " + i);
        }

        mBinding.rvGeneric.setLayoutManager(new LinearLayoutManager(this));

        mBinding.rvGeneric.setAdapter(new GenericAdapter<String, RowListChildItemBinding>(stringList, R.layout.row_list_child_item,
                (binding, item, allItem, itemPosition) -> {
                    binding.tvChildItem.setText(item);
                    binding.tvChildItem.setOnClickListener(v -> Toast.makeText(this, item + "clicked", Toast.LENGTH_SHORT).show());
                }));


      /*  GenericAdapter myAdapter = new GenericAdapter<>(stringList, R.layout.row_list_child_item,
                new GenericRecyclerCallBack<RowListChildItemBinding, String>() {
                    *//**
                     * @param binding      viewBinding of a row in a recycler view
                     * @param item         object of a row in a recycler view
                     * @param allItem      list of all items in a recycler view
                     * @param itemPosition position of an item in a recycler view
                     *//*
                    @Override
                    public void bindData(RowListChildItemBinding binding, String item, List<String> allItem, int itemPosition) {
                        *//*setup your views for row in recycler view here*//*
                        binding.tvChildItem.setText(item);
                    }
                });

        mBinding.rvGeneric.setAdapter(myAdapter);
   */ }
}
