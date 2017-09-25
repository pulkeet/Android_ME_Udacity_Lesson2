package com.example.android.android_me.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.android.android_me.R;

/**
 * Created by Pulkeet on 24-09-2017.
 */

public class MasterActivity extends AppCompatActivity implements MasterListFragment.OnImageClickListener{

    private int headIndex;
    private int bodyIndex;
    private int legIndex;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.fragment_master_activity);
    }

    @Override
    public void onImageSelected(int position) {

        Toast.makeText(this , "position :" + position  , Toast.LENGTH_SHORT).show();

        //If bodyPartNumber == 0 i.e headIndex
        //If bodyPartNumber == 1 i.e boddIndex
        //If bodyPartNumber == 2 i.e legIndex

        int bodyPartNumber = position/12;

        int listIndex = position -12*bodyPartNumber;
        switch (bodyPartNumber){

            case 0:
                headIndex = listIndex;
                break;
            case 1:
                bodyIndex = listIndex;
                break;
            case 2:
                legIndex = listIndex;
                break;
            default:
                break;
        }

        Bundle bundle = new Bundle();
        bundle.putInt("headIndex", headIndex);
        bundle.putInt("bodyIndex", bodyIndex);
        bundle.putInt("legIndex", legIndex);

        final Intent intent = new Intent(this , MainActivity.class);
        intent.putExtras(bundle);

        Button button = (Button) findViewById(R.id.next_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent);
            }
        });

    }
}
