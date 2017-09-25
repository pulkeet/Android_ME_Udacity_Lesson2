package com.example.android.android_me.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.android.android_me.R;
import com.example.android.android_me.data.AndroidDrawableAssest;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pulkeet on 20-06-2017.
 */

public class BodyPartFragment extends Fragment {

    public static final String IMAGE_ID_LIST = "image_id_list";
    public static final String LIST_INDEX = "list_index";

    private static final String TAG = BodyPartFragment.class.getSimpleName();
    private List<Integer> mImageIds;
    private int mListIndex;

    public void setmListIndex(int mListIndex) {
        this.mListIndex = mListIndex;
    }

    public void setmImageIds(List<Integer> mImageIds) {
        this.mImageIds = mImageIds;
    }

    public BodyPartFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        if (savedInstanceState != null) {
            mImageIds = savedInstanceState.getIntegerArrayList(IMAGE_ID_LIST);
            mListIndex = savedInstanceState.getInt(LIST_INDEX);
        }
        View rootView = inflater.inflate(R.layout.fragment_body_part, container, false);

        final ImageView bodyImageView = (ImageView) rootView.findViewById(R.id.imageViewBody);
        if (mImageIds != null) {
            bodyImageView.setImageResource(mImageIds.get(mListIndex));

            bodyImageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    if (mListIndex < mImageIds.size() - 1) {
                        mListIndex++;
                    }else{
                        mListIndex =0;
                    }

                    bodyImageView.setImageResource(mImageIds.get(mListIndex));
                }
            });
        } else {
            Log.d(TAG, "No imageIds");
        }
        return rootView;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt(LIST_INDEX, mListIndex);
        outState.putIntegerArrayList(IMAGE_ID_LIST, (ArrayList<Integer>) mImageIds);
    }
}
