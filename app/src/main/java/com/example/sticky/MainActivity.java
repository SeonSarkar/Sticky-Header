package com.example.sticky;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.sticky.databinding.ActivityMainBinding;
import com.seon.hornet.adapters.adapter.StickyAdapter;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding mBinding;
    StickyAdapter mStickyAdapter;

    List<MenuItem> listMenuItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        mBinding.btnSticky.setOnClickListener(v -> startActivity(new Intent(this, StickyListActivity.class)));
        mBinding.btnNormal.setOnClickListener(v -> startActivity(new Intent(this, RecyclerViewActivity.class)));
        mBinding.btnExpandable.setOnClickListener(v -> startActivity(new Intent(this, ExpandableListActivity.class)));

    }


}
