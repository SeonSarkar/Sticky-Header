package com.example.sticky;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.sticky.databinding.ActivityExpandableListBinding;
import com.example.sticky.databinding.RowListChildItemBinding;
import com.example.sticky.databinding.RowListHeaderItemBinding;
import com.seon.hornet.adapters.adapter.ExpandableAdapter;
import com.seon.hornet.adapters.callback.ExpandableRecyclerCallBack;
import com.seon.hornet.adapters.model.ExpandableItem;

import java.util.ArrayList;
import java.util.List;

public class ExpandableListActivity extends AppCompatActivity {

    ActivityExpandableListBinding mBinding;

    List<MenuItem> listMenuItem = new ArrayList<>();
    ExpandableAdapter mExpandableRecyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_expandable_list);


        listMenuItem = new ArrayList<>();
        listMenuItem.add(new MenuItem("Child"));
        listMenuItem.add(new MenuItem("Child"));
        listMenuItem.add(new MenuItem("Child"));
        listMenuItem.add(new MenuItem("Child"));
        listMenuItem.add(new MenuItem("Child"));
        listMenuItem.add(new MenuItem("Child"));
        listMenuItem.add(new MenuItem("Child"));
        listMenuItem.add(new MenuItem("Child"));
        listMenuItem.add(new MenuItem("Child"));


        List<ExpandableItem<String, MenuItem>> items = new ArrayList<>();
        items.add(new ExpandableItem<>(listMenuItem, "Expandable Header 1"));
        items.add(new ExpandableItem<>(listMenuItem, "Expandable Header 2"));
        items.add(new ExpandableItem<>(listMenuItem, "Expandable Header 3"));


        mExpandableRecyclerAdapter = new ExpandableAdapter<>(items, R.layout.row_list_header_item, R.layout.row_list_child_item,
                new ExpandableRecyclerCallBack<String, MenuItem, RowListHeaderItemBinding, RowListChildItemBinding>() {
                    /**
                     * @param header view binding of a header
                     * @param item object in a header view
                     * @param groupPosition position of a group
                     */
                    @Override
                    public void bindGroup(RowListHeaderItemBinding header, String item, int groupPosition) {
                        header.tvHeaderItem.setText(item);
                    }

                    /**
                     * @param child view binding of child item in a sticky recycler view
                     * @param item object in a child view
                     * @param groupPosition position of a group of associated child
                     * @param childPosition position of a child
                     */
                    @Override
                    public void bindChild(RowListChildItemBinding child, MenuItem item, int groupPosition, int childPosition) {
                        child.tvChildItem.setText(item.getItemName());
                    }

                    @Override
                    public void onExpanded(int groupPosition) {
                        Toast.makeText(ExpandableListActivity.this, "expanded group "+groupPosition, Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onCollapsed(int groupPosition) {
                        Toast.makeText(ExpandableListActivity.this, "collapsed group "+groupPosition, Toast.LENGTH_SHORT).show();
                    }
                });

        mBinding.rvExpandable.setLayoutManager(new LinearLayoutManager(this));
        mBinding.rvExpandable.setAdapter(mExpandableRecyclerAdapter);
    }
}
