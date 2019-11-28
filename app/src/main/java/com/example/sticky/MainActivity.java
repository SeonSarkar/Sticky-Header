package com.example.sticky;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.sticky.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        mBinding.btnSticky.setOnClickListener(v -> startActivity(new Intent(this, StickyListActivity.class)));
        mBinding.btnNormal.setOnClickListener(v -> startActivity(new Intent(this, RecyclerViewActivity.class)));
        mBinding.btnExpandable.setOnClickListener(v -> startActivity(new Intent(this, ExpandableListActivity.class)));
    }


}
