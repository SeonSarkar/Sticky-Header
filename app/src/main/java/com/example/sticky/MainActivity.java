package com.example.sticky;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import com.example.sticky.adapter.RecyclerCallBack;
import com.example.sticky.adapter.StickyAdapter;
import com.example.sticky.databinding.ActivityMainBinding;
import com.example.sticky.databinding.RowListChildItemBinding;
import com.example.sticky.databinding.RowListHeaderItemBinding;
import com.example.sticky.itemdecoration.ItemDecoration;
import com.example.sticky.model.MenuItem;
import com.example.sticky.model.StickeyItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding mBinding;
    StickyAdapter mStickyAdapter;

    List<MenuItem> listMenuItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        listMenuItem = new ArrayList<>();
        listMenuItem.add(new MenuItem("Header", MenuItem.HEADER_TYPE, true));

        listMenuItem.add(new MenuItem("Child", MenuItem.CHILD_TYPE, false));
        listMenuItem.add(new MenuItem("Child", MenuItem.CHILD_TYPE, false));
        listMenuItem.add(new MenuItem("Child", MenuItem.CHILD_TYPE, false));
        listMenuItem.add(new MenuItem("Child", MenuItem.CHILD_TYPE, false));
        listMenuItem.add(new MenuItem("Child", MenuItem.CHILD_TYPE, false));
        listMenuItem.add(new MenuItem("Child", MenuItem.CHILD_TYPE, false));
        listMenuItem.add(new MenuItem("Child", MenuItem.CHILD_TYPE, false));
        listMenuItem.add(new MenuItem("Child", MenuItem.CHILD_TYPE, false));
        listMenuItem.add(new MenuItem("Child", MenuItem.CHILD_TYPE, false));

        listMenuItem.add(new MenuItem("Header1", MenuItem.HEADER_TYPE, true));

        listMenuItem.add(new MenuItem("Child1", MenuItem.CHILD_TYPE, false));
        listMenuItem.add(new MenuItem("Child1", MenuItem.CHILD_TYPE, false));
        listMenuItem.add(new MenuItem("Child1", MenuItem.CHILD_TYPE, false));
        listMenuItem.add(new MenuItem("Child1", MenuItem.CHILD_TYPE, false));
        listMenuItem.add(new MenuItem("Child1", MenuItem.CHILD_TYPE, false));
        listMenuItem.add(new MenuItem("Child1", MenuItem.CHILD_TYPE, false));
        listMenuItem.add(new MenuItem("Child1", MenuItem.CHILD_TYPE, false));
        listMenuItem.add(new MenuItem("Child1", MenuItem.CHILD_TYPE, false));
        listMenuItem.add(new MenuItem("Child1", MenuItem.CHILD_TYPE, false));
        listMenuItem.add(new MenuItem("Child1", MenuItem.CHILD_TYPE, false));


        listMenuItem.add(new MenuItem("Header2", MenuItem.HEADER_TYPE, true));

        listMenuItem.add(new MenuItem("Child2", MenuItem.CHILD_TYPE, false));
        listMenuItem.add(new MenuItem("Child2", MenuItem.CHILD_TYPE, false));
        listMenuItem.add(new MenuItem("Child2", MenuItem.CHILD_TYPE, false));
        listMenuItem.add(new MenuItem("Child2", MenuItem.CHILD_TYPE, false));
        listMenuItem.add(new MenuItem("Child2", MenuItem.CHILD_TYPE, false));
        listMenuItem.add(new MenuItem("Child2", MenuItem.CHILD_TYPE, false));
        listMenuItem.add(new MenuItem("Child2", MenuItem.CHILD_TYPE, false));
        listMenuItem.add(new MenuItem("Child2", MenuItem.CHILD_TYPE, false));
        listMenuItem.add(new MenuItem("Child2", MenuItem.CHILD_TYPE, false));


        listMenuItem.add(new MenuItem("Header3", MenuItem.HEADER_TYPE, true));

        listMenuItem.add(new MenuItem("Child3", MenuItem.CHILD_TYPE, false));
        listMenuItem.add(new MenuItem("Child3", MenuItem.CHILD_TYPE, false));
        listMenuItem.add(new MenuItem("Child3", MenuItem.CHILD_TYPE, false));
        listMenuItem.add(new MenuItem("Child3", MenuItem.CHILD_TYPE, false));
        listMenuItem.add(new MenuItem("Child3", MenuItem.CHILD_TYPE, false));
        listMenuItem.add(new MenuItem("Child3", MenuItem.CHILD_TYPE, false));
        listMenuItem.add(new MenuItem("Child3", MenuItem.CHILD_TYPE, false));
        listMenuItem.add(new MenuItem("Child3", MenuItem.CHILD_TYPE, false));
        listMenuItem.add(new MenuItem("Child3", MenuItem.CHILD_TYPE, false));


        listMenuItem.add(new MenuItem("Header4", MenuItem.HEADER_TYPE, true));

        listMenuItem.add(new MenuItem("Child4", MenuItem.CHILD_TYPE, false));
        listMenuItem.add(new MenuItem("Child4", MenuItem.CHILD_TYPE, false));
        listMenuItem.add(new MenuItem("Child4", MenuItem.CHILD_TYPE, false));
        listMenuItem.add(new MenuItem("Child4", MenuItem.CHILD_TYPE, false));
        listMenuItem.add(new MenuItem("Child4", MenuItem.CHILD_TYPE, false));
        listMenuItem.add(new MenuItem("Child4", MenuItem.CHILD_TYPE, false));
        listMenuItem.add(new MenuItem("Child4", MenuItem.CHILD_TYPE, false));
        listMenuItem.add(new MenuItem("Child4", MenuItem.CHILD_TYPE, false));
        listMenuItem.add(new MenuItem("Child4", MenuItem.CHILD_TYPE, false));

        List<StickeyItem<MenuItem, MenuItem>> items = new ArrayList<>();
        items.add(new StickeyItem<>(listMenuItem, new MenuItem("Child4", MenuItem.CHILD_TYPE, false)));

        mStickyAdapter = new StickyAdapter<>(items, R.layout.row_list_header_item, R.layout.row_list_child_item,
                new RecyclerCallBack<MenuItem, MenuItem, RowListHeaderItemBinding, RowListChildItemBinding>() {
                    @Override
                    public void bindHeader(RowListHeaderItemBinding header, MenuItem item) {

                    }

                    @Override
                    public void bindChild(RowListChildItemBinding child, MenuItem item) {

                    }
                });
        mBinding.rvSticky.setLayoutManager(new LinearLayoutManager(this));
        mBinding.rvSticky.setHasFixedSize(true);
        mBinding.rvSticky.addItemDecoration(new ItemDecoration(mBinding.rvSticky, mStickyAdapter));
        mBinding.rvSticky.setAdapter(mStickyAdapter);


    }


}
