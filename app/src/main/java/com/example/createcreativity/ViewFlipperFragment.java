package com.example.createcreativity;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ViewFlipperFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ViewFlipperFragment extends Fragment {
    @BindView(R.id.view_flipper)
    ViewFlipper viewFlipper;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private  FragmentActionListener fragmentActionListener;
    private  View rootView;
    private  Context context;
    public ViewFlipperFragment() {
    }

    public ViewFlipperFragment(Context context) {
        this.context = context;
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ViewFlipperFragment.
     */
    // TODO: Rename and change types and number of parameters
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_view_flipper, container, false);
        ButterKnife.bind(this,rootView);
        initUI();
        return  rootView;
    }

    public  void initUI() {
        int images[] = {R.drawable.ic_launcher_foreground, R.drawable.ic_launcher_background};
        for (int image : images) {
            viewFlipping(image);
        }
    }
        public void viewFlipping(int image) {
            ImageView imageView = new ImageView(context);
            viewFlipper.addView(imageView);
            imageView.setBackgroundResource(image);
            viewFlipper.setAutoStart(true);
            viewFlipper.setFlipInterval(4000);
            viewFlipper.setInAnimation(context, R.anim.move_in);
            //viewFlipper.setOutAnimation();}
    }
    public static ViewFlipperFragment newInstance(String param1, String param2) {
        ViewFlipperFragment fragment = new ViewFlipperFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public  void setFragmentActionListener(FragmentActionListener fragmentActionListener) {
        this.fragmentActionListener = fragmentActionListener;
    }

    @Override
    public  void  onActivityCreated(@Nullable Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        if (savedInstanceState!= null){
            fragmentActionListener = (FragmentActionListener) getActivity();
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }
}