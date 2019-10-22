package com.example.sticky;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.sticky.databinding.ActivityStickyListBinding;
import com.example.sticky.databinding.RowListChildItemBinding;
import com.example.sticky.databinding.RowListHeaderItemBinding;
import com.seon.hornet.adapters.adapter.StickyAdapter;
import com.seon.hornet.adapters.callback.StickyRecyclerCallBack;
import com.seon.hornet.adapters.itemdecoration.ItemDecoration;
import com.seon.hornet.adapters.model.StickyItem;

import java.util.ArrayList;
import java.util.List;

public class StickyListActivity extends AppCompatActivity {
    StickyAdapter mStickyAdapter;
    ActivityStickyListBinding mBinding;
    List<MenuItem> listMenuItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_sticky_list);

        listMenuItem = new ArrayList<>();
        listMenuItem.add(new MenuItem("Child", MenuItem.CHILD_TYPE, false));
        listMenuItem.add(new MenuItem("Child", MenuItem.CHILD_TYPE, false));
        listMenuItem.add(new MenuItem("Child", MenuItem.CHILD_TYPE, false));
        listMenuItem.add(new MenuItem("Child", MenuItem.CHILD_TYPE, false));
        listMenuItem.add(new MenuItem("Child", MenuItem.CHILD_TYPE, false));
        listMenuItem.add(new MenuItem("Child", MenuItem.CHILD_TYPE, false));
        listMenuItem.add(new MenuItem("Child", MenuItem.CHILD_TYPE, false));
        listMenuItem.add(new MenuItem("Child", MenuItem.CHILD_TYPE, false));
        listMenuItem.add(new MenuItem("Child", MenuItem.CHILD_TYPE, false));


        List<StickyItem<String, MenuItem>> items = new ArrayList<>();
        items.add(new StickyItem<>(listMenuItem, "header 1"));
        items.add(new StickyItem<>(listMenuItem, "header 2"));
        items.add(new StickyItem<>(listMenuItem, "header 3"));

        mStickyAdapter = new StickyAdapter<String, MenuItem, RowListHeaderItemBinding, RowListChildItemBinding>(items, R.layout.row_list_header_item, R.layout.row_list_child_item,
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
        mBinding.rvSticky.setLayoutManager(new LinearLayoutManager(this));
        mBinding.rvSticky.setHasFixedSize(true);
        mBinding.rvSticky.addItemDecoration(new ItemDecoration(mBinding.rvSticky, mStickyAdapter));
        mBinding.rvSticky.setAdapter(mStickyAdapter);


    }
}
