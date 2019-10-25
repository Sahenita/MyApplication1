package com.example.accenture_nevigation_app;

import android.animation.ObjectAnimator;
import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;


public class Fragment1 extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    View view;
TextView text;
Button button;
    Button button1;
LinearLayout lin_txt;
    int viewHeight,viewWeight,transition_point;
    float f;
    public Fragment1() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragment1.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment1 newInstance(String param1, String param2) {
        Fragment1 fragment = new Fragment1();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        view=inflater.inflate(R.layout.fragment1, container, false);
        //music player
        text=view.findViewById(R.id.text);
        lin_txt=view.findViewById(R.id.lin_txt);
     /*   ViewTreeObserver viewTreeObserver = lin_txt.getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                @Override
                public void onGlobalLayout() {

                    lin_txt.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    viewHeight = lin_txt.getHeight();
                    viewWeight = lin_txt.getWidth();
                    transition_point=viewWeight/3;
                    f = (float) transition_point;

                }
            });
        }*/
     /*   button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ObjectAnimator anim = ObjectAnimator.ofFloat(text,"x",f);
                anim.setDuration(500); // duration 5 seconds
                anim.start();
               *//* TranslateAnimation animation = new TranslateAnimation(0, 50, 0, 100);
                animation.setDuration(1000);
                animation.setFillAfter(false);
                animation.setAnimationListener(new MyAnimationListener());
                text.startAnimation(animation);
                LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(text.getWidth(), text.getHeight());
                lp.setMargins(50, 100, 0, 0);
                text.setLayoutParams(lp);*//*
//                text.clearAnimation();
//                LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(text.getWidth(), text.getHeight());
//                lp.setMargins(50, 100, 0, 0);
//                text.setLayoutParams(lp);
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                text.clearAnimation();
//                LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(imageView.getWidth(), imageView.getHeight());
//                lp.setMargins(50, 100, 0, 0);
//                imageView.setLayoutParams(lp);
            }
        });*/
        return view;
    }
    private class MyAnimationListener implements Animation.AnimationListener {

        @Override
        public void onAnimationEnd(Animation animation) {
            text.clearAnimation();
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(text.getWidth(), text.getHeight());
            lp.setMargins(50, 100, 0, 0);
            text.setLayoutParams(lp);
        }

        @Override
        public void onAnimationRepeat(Animation animation) {
        }

        @Override
        public void onAnimationStart(Animation animation) {
        }

    }

}
