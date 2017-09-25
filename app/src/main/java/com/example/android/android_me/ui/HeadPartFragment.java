package com.example.android.android_me.ui;

import android.os.Bundle;
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
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * create an instance of this fragment.
 */
public class HeadPartFragment extends Fragment {
    public static final String IMAGE_ID_LIST = "image_id_list";
    public static final String LIST_INDEX = "list_index";

    private static final String TAG = HeadPartFragment.class.getSimpleName();
    private List<Integer> mImageIds;
    private int mListIndex;

    public void setmListIndex(int mListIndex) {
        this.mListIndex = mListIndex;
    }

    public void setmImageIds(List<Integer> mImageIds) {
        this.mImageIds = mImageIds;
    }


    public HeadPartFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            mImageIds = savedInstanceState.getIntegerArrayList(IMAGE_ID_LIST);
            mListIndex = savedInstanceState.getInt(LIST_INDEX);
        }

        View rootView = inflater.inflate(R.layout.fragment_head_part, container, false);

       final ImageView imageViewHead = (ImageView) rootView.findViewById(R.id.imageViewHead);

        if (mImageIds != null) {
            imageViewHead.setImageResource(mImageIds.get(mListIndex));

            imageViewHead.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    if (mListIndex < mImageIds.size() - 1) {
                        mListIndex++;
                    }else{
                        mListIndex =0;
                    }

                    imageViewHead.setImageResource(mImageIds.get(mListIndex));
                }
            });
        } else {
            Log.d(TAG, "No imageIds");
        }
        // Inflate the layout for this fragment
        return rootView;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt(LIST_INDEX, mListIndex);
        outState.putIntegerArrayList(IMAGE_ID_LIST, (ArrayList<Integer>) mImageIds);
    }

}
