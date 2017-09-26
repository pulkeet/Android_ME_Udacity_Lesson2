package com.example.android.android_me.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import com.example.android.android_me.R;
import com.example.android.android_me.data.AndroidDrawableAssest;

import java.util.logging.Logger;

/**
 * Created by Pulkeet on 24-09-2017.
 */

public class MasterActivity extends AppCompatActivity implements MasterListFragment.OnImageClickListener{

    private static final String TAG = MasterActivity.class.getSimpleName();
    private int headIndex;
    private int bodyIndex;
    private int legIndex;
    private boolean mTwoPane;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.fragment_master_activity);

        if (findViewById(R.id.activity_main_relativeLayout) != null) {
            mTwoPane = true;
            Log.d(TAG , " : Tablet");
            Button button=(Button)findViewById(R.id.next_button);
            button.setVisibility(View.GONE);

            GridView gridView = (GridView) findViewById(R.id.images_grid_view);
            gridView.setNumColumns(2);
            FragmentManager fragmentManager = getSupportFragmentManager();

            BodyPartFragment bodyPartFragment = new BodyPartFragment();
            bodyPartFragment.setmImageIds(AndroidDrawableAssest.getBody());
            fragmentManager.beginTransaction().add(R.id.bodyContainer, bodyPartFragment).commit();

            HeadPartFragment headPartFragment = new HeadPartFragment();
            headPartFragment.setmImageIds(AndroidDrawableAssest.getHead());
            fragmentManager.beginTransaction().add(R.id.headContainer, headPartFragment)
                    .commit();

            LegPartFragment legPartFragment = new LegPartFragment();
            legPartFragment.setmImageIds(AndroidDrawableAssest.getLegs());
            fragmentManager.beginTransaction().add(R.id.legContainer, legPartFragment).commit();

        } else {
            mTwoPane = false;
            Log.d(TAG , " : Phone");
        }
        
    }

    @Override
    public void onImageSelected(int position) {

        Toast.makeText(this , "position :" + position  , Toast.LENGTH_SHORT).show();

        //If bodyPartNumber == 0 i.e headIndex
        //If bodyPartNumber == 1 i.e boddIndex
        //If bodyPartNumber == 2 i.e legIndex

        int bodyPartNumber = position/12;

        int listIndex = position -12*bodyPartNumber;

       if(mTwoPane){

           BodyPartFragment newFragment = new BodyPartFragment();

           switch (bodyPartNumber){
               case 0:

                   newFragment.setmImageIds(AndroidDrawableAssest.getHead());
                   newFragment.setmListIndex(listIndex);
                   getSupportFragmentManager().beginTransaction()
                           .replace(R.id.headContainer,newFragment)
                           .commit();
                   break;
               case 1:
                   newFragment.setmImageIds(AndroidDrawableAssest.getBody());
                   newFragment.setmListIndex(listIndex);
                   getSupportFragmentManager().beginTransaction()
                           .replace(R.id.bodyContainer, newFragment)
                           .commit();
                   break;
               case 2:
                   newFragment.setmImageIds(AndroidDrawableAssest.getLegs());
                   newFragment.setmListIndex(listIndex);
                   getSupportFragmentManager().beginTransaction()
                           .replace(R.id.legContainer, newFragment)
                           .commit();
                   break;
               default:
                   break;
           }
       }else {
           switch (bodyPartNumber) {
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

           final Intent intent = new Intent(this, MainActivity.class);
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
}
