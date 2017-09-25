package com.example.android.android_me.ui;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.android.android_me.R;

/**
 * Created by Pulkeet on 24-09-2017.
 */

public class MasterActivity extends AppCompatActivity implements MasterListFragment.OnImageClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.fragment_master_activity);
    }

    @Override
    public void onImageSelected(int position) {

        Toast.makeText(this , "position :" + position  , Toast.LENGTH_SHORT).show();

    }
}
