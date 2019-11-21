package com.example.sticky;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.SimpleItemAnimator;

import com.example.sticky.adapter.ExpandableRecyclerAdapter;
import com.example.sticky.databinding.ActivityExpandableListBinding;
import com.example.sticky.databinding.RowListChildItemBinding;
import com.example.sticky.databinding.RowListHeaderItemBinding;
import com.seon.hornet.adapters.callback.StickyRecyclerCallBack;
import com.seon.hornet.adapters.model.StickyItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ExpandableListActivity extends AppCompatActivity {

    ActivityExpandableListBinding mBinding;

    List<MenuItem> listMenuItem = new ArrayList<>();
    ExpandableRecyclerAdapter mExpandableRecyclerAdapter;

    int checkVisibility=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_expandable_list);


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
        items.add(new StickyItem<>(listMenuItem, "Expandable Header 1"));
        items.add(new StickyItem<>(listMenuItem, "Expandable Header 2"));
        items.add(new StickyItem<>(listMenuItem, "Expandable Header 3"));

        mExpandableRecyclerAdapter = new ExpandableRecyclerAdapter(items, R.layout.row_list_header_item, R.layout.row_list_child_item,
                new StickyRecyclerCallBack<String, MenuItem, RowListHeaderItemBinding, RowListChildItemBinding>() {
                    @Override
                    public void bindHeader(RowListHeaderItemBinding header, String item) {
                        header.tvHeaderItem.setText(item);

                        header.llHeader.setOnClickListener(view -> {

                            if (checkVisibility==0){
                                Toast.makeText(ExpandableListActivity.this, "Clicked  " + item, Toast.LENGTH_SHORT).show();

                                //Yesma Child ko Visibility Manage garna Sakina Maile Boss
                            }
                        });
                    }

                    @Override
                    public void bindChild(RowListChildItemBinding child, MenuItem item) {
                        child.tvChildItem.setText(item.getItemName());

                    }
                });

        mBinding.rvExpandable.setLayoutManager(new LinearLayoutManager(this));
        mBinding.rvExpandable.setHasFixedSize(true);
        mBinding.rvExpandable.setAdapter(mExpandableRecyclerAdapter);
        ((SimpleItemAnimator) (Objects.requireNonNull(mBinding.rvExpandable.getItemAnimator()))).setSupportsChangeAnimations(false);
    }
}
