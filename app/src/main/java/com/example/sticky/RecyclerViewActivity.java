package com.example.sticky;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.sticky.databinding.ActivityRecyclerViewBinding;
import com.example.sticky.databinding.RowListChildItemBinding;
import com.seon.hornet.adapters.adapter.GenericAdapter;

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
    }
}
