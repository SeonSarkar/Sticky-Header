package com.example.sticky;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.sticky.adapter.ExpandableRecyclerAdapter;
import com.example.sticky.databinding.ActivityExpandableListBinding;
import com.example.sticky.databinding.RowListChildItemBinding;
import com.example.sticky.databinding.RowListHeaderItemBinding;
import com.seon.hornet.adapters.callback.StickyRecyclerCallBack;
import com.seon.hornet.adapters.itemdecoration.ItemDecoration;
import com.seon.hornet.adapters.model.StickyItem;

import java.util.ArrayList;
import java.util.List;

public class ExpandableListActivity extends AppCompatActivity {

    ActivityExpandableListBinding mBinding;

    List<MenuItem> listMenuItem = new ArrayList<>();
    ExpandableRecyclerAdapter mExpandableRecyclerAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_expandable_list);


        List<StickyItem<String, MenuItem>> items = new ArrayList<>();
        items.add(new StickyItem<>(listMenuItem, "header 1"));
        items.add(new StickyItem<>(listMenuItem, "header 2"));
        items.add(new StickyItem<>(listMenuItem, "header 3"));

        mExpandableRecyclerAdapter = new ExpandableRecyclerAdapter(items, R.layout.row_list_header_item, R.layout.row_list_child_item,
                new StickyRecyclerCallBack<String, MenuItem, RowListHeaderItemBinding, RowListChildItemBinding>() {
                    @Override
                    public void bindHeader(RowListHeaderItemBinding header, String item) {
                        header.tvHeaderItem.setText(item);
                    }

                    @Override
                    public void bindChild(RowListChildItemBinding child, MenuItem item) {
                        child.tvChildItem.setText(item.getItemName());
                    }
                });

        mBinding.rvExpandable.setLayoutManager(new LinearLayoutManager(this));
        mBinding.rvExpandable.setHasFixedSize(true);
        mBinding.rvExpandable.addItemDecoration(new ItemDecoration(mBinding.rvExpandable, mExpandableRecyclerAdapter));
        mBinding.rvExpandable.setAdapter(mExpandableRecyclerAdapter);


    }
}
