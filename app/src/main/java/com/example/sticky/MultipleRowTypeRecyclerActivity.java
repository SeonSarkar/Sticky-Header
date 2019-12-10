package com.example.sticky;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.sticky.databinding.ActivityMultipleRowTypeBinding;

/**
 * Created by suman.ghimire.
 */
public class MultipleRowTypeRecyclerActivity extends AppCompatActivity {

    ActivityMultipleRowTypeBinding mBinding;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding= DataBindingUtil.setContentView(this,R.layout.activity_multiple_row_type);
    }



}
