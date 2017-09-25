package com.example.android.android_me.ui;


import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.android.android_me.R;
import com.example.android.android_me.data.AndroidDrawableAssest;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        if (savedInstanceState == null) {
            //HeadFragment
            HeadPartFragment headPartFragment = new HeadPartFragment();

            headPartFragment.setmImageIds(AndroidDrawableAssest.getHead());
            headPartFragment.setmListIndex(1);

            FragmentManager fragmentManager = getSupportFragmentManager();

            fragmentManager.beginTransaction().add(R.id.headContainer, headPartFragment)
                    .commit();

            //BodyFragment

            BodyPartFragment bodyPartFragment = new BodyPartFragment();

            bodyPartFragment.setmImageIds(AndroidDrawableAssest.getBody());
            bodyPartFragment.setmListIndex(1);

            FragmentManager fragmentManager1 = getSupportFragmentManager();
            fragmentManager1.beginTransaction().add(R.id.bodyContainer, bodyPartFragment).commit();


            //LegFragment

            LegPartFragment legPartFragment = new LegPartFragment();

            legPartFragment.setmImageIds(AndroidDrawableAssest.getLegs());
            legPartFragment.setmListIndex(1);

            FragmentManager fragmentManager2 = getSupportFragmentManager();
            fragmentManager2.beginTransaction().add(R.id.legContainer, legPartFragment).commit();
        }
    }
}
