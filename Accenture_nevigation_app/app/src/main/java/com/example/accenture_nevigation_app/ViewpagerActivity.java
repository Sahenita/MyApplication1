package com.example.accenture_nevigation_app;

import android.animation.ObjectAnimator;
import android.content.res.TypedArray;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.*;
import com.example.accenture_nevigation_app.Utility.Utils;
import com.example.accenture_nevigation_app.Utility.UtilsDevice;
import com.example.accenture_nevigation_app.Utility.UtilsMiscellaneous;


public class ViewpagerActivity extends AppCompatActivity implements Animation.AnimationListener {
    Customviewpager viewPager;
    ViewPagerAdapter viewPagerAdapter;
    TabLayout tablayout;
    ImageView anim_img1, anim_img2, anim_img3;
    LinearLayout tab1, tab2, tab3;
    Animation animation, animation2;
    LinearLayout.LayoutParams layoutparamslayoutparams;
    LinearLayout.LayoutParams layoutparamslayoutparams1;
    LinearLayout.LayoutParams layoutparamslayoutparams2;
    LinearLayout tab_block;
    int viewHeight, viewWeight, transition_point;
    ImageView zoom_img1, zoom_img2, zoom_img3;
    float f;

    private int[] tabIcons = {
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher
    };
    android.support.v7.widget.Toolbar toolbar;
    private DrawerLayout mDrawerLayout;
    private android.support.v7.app.ActionBarDrawerToggle mActionBarDrawerToggle;
    NavigationView navigationView;
    RelativeLayout contenLinView;
    private float lastTranslate = 0.0f;
    com.example.accenture_nevigation_app.AnimatingRelativeLayout animatingRelativeLayout;
    LinearLayout lin_menu;
    RelativeLayout rl_shadow;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewpager);
        // Inflate the layout for this fragment
        // tablayout = findViewById(R.id.tablayout);
//        init_slider();
//        init_navigator();
        animatingRelativeLayout=findViewById(R.id.navigation_view);
        //customActionBar();
        lin_menu = (LinearLayout)findViewById(R.id.lin_menu);
        rl_shadow=findViewById(R.id.rl_shadow);
//        new Utils().hideCheck(lin_menu, ViewpagerActivity.this);
        lin_menu.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
//                                            animatingRelativeLayout.setVisibility(View.VISIBLE);
//                                            animatingRelativeLayout.show();
                                            if (!animatingRelativeLayout.isVisible()) {
                                                animatingRelativeLayout.show();
                                                rl_shadow.setVisibility(View.VISIBLE);
                                            } else {
                                                animatingRelativeLayout.hide();
                                                rl_shadow.setVisibility(View.GONE);

                                            }
                                        }
                                    });
        animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in);
        animation2 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_out);
        animation.setAnimationListener(this);
        anim_img1 = findViewById(R.id.anim_img1);
        anim_img2 = findViewById(R.id.anim_img2);
        anim_img3 = findViewById(R.id.anim_img3);
        zoom_img1 = findViewById(R.id.zoom_img1);
        zoom_img2 = findViewById(R.id.zoom_img2);
        zoom_img3 = findViewById(R.id.zoom_img3);
        tab_block = findViewById(R.id.tab_block);
        layoutparamslayoutparams = (LinearLayout.LayoutParams) zoom_img1.getLayoutParams();
        layoutparamslayoutparams1 = (LinearLayout.LayoutParams) zoom_img2.getLayoutParams();
        layoutparamslayoutparams2 = (LinearLayout.LayoutParams) zoom_img3.getLayoutParams();
        layoutparamslayoutparams2 = (LinearLayout.LayoutParams) zoom_img3.getLayoutParams();

        tab1 = findViewById(R.id.tab1);
        tab2 = findViewById(R.id.tab2);
        tab3 = findViewById(R.id.tab3);
        viewPager = findViewById(R.id.view_pager);
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        //Add fragment here
        viewPagerAdapter.AddFragment(new Fragment1(), "");
        viewPagerAdapter.AddFragment(new Fragment2(), "");
        viewPagerAdapter.AddFragment(new Fragment3(), "");
        viewPager.setAdapter(viewPagerAdapter);
        viewPager.setCurrentItem(1);
        viewPager.setPagingEnabled(true);
//        anim_img1.setVisibility(View.INVISIBLE);
//        anim_img2.setVisibility(View.VISIBLE);
//        anim_img3.setVisibility(View.INVISIBLE);

        tab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                anim_img1.setVisibility(View.VISIBLE);
//                anim_img2.setVisibility(View.INVISIBLE);
//                anim_img3.setVisibility(View.INVISIBLE);
                ObjectAnimator anim = ObjectAnimator.ofFloat(anim_img1, "x", 0);
                anim.setDuration(200); // duration 5 seconds
                anim.start();
                zoom_img1.startAnimation(animation);
                zoom_img2.startAnimation(animation2);
                zoom_img3.startAnimation(animation2);
                layoutparamslayoutparams.setMargins(0, 0, 0, 15);
                zoom_img1.setLayoutParams(layoutparamslayoutparams);
                layoutparamslayoutparams1.setMargins(0, 0, 0, 0);
                zoom_img2.setLayoutParams(layoutparamslayoutparams1);
                layoutparamslayoutparams2.setMargins(0, 0, 0, 0);
                zoom_img3.setLayoutParams(layoutparamslayoutparams2);
                viewPager.setCurrentItem(0, false);

            }
        });
        tab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                anim_img1.setVisibility(View.VISIBLE);
//                anim_img2.setVisibility(View.VISIBLE);
//                anim_img3.setVisibility(View.INVISIBLE);
//                TranslateAnimation transAnimation= new TranslateAnimation(transition_point, transition_point+transition_point, 0, 0);
//                anim_img1.startAnimation(transAnimation);
                ObjectAnimator anim = ObjectAnimator.ofFloat(anim_img1, "x", f);
                anim.setDuration(200); // duration 5 seconds
                anim.start();
                zoom_img1.startAnimation(animation2);
                zoom_img2.startAnimation(animation);
                zoom_img3.startAnimation(animation2);
                layoutparamslayoutparams.setMargins(0, 0, 0, 0);
                zoom_img1.setLayoutParams(layoutparamslayoutparams);
                layoutparamslayoutparams1.setMargins(0, 0, 0, 15);
                zoom_img2.setLayoutParams(layoutparamslayoutparams1);
                layoutparamslayoutparams2.setMargins(0, 0, 0, 0);
                zoom_img3.setLayoutParams(layoutparamslayoutparams2);
                viewPager.setCurrentItem(1, false);
            }
        });
        tab3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                anim_img1.setVisibility(View.VISIBLE);
//                anim_img2.setVisibility(View.INVISIBLE);
//                anim_img3.setVisibility(View.VISIBLE);
//                TranslateAnimation transAnimation= new TranslateAnimation(transition_point, transition_point+transition_point, 0, 0);
//                anim_img1.startAnimation(transAnimation);
                ObjectAnimator anim = ObjectAnimator.ofFloat(anim_img1, "x", f * 2);
                anim.setDuration(200); // duration 5 seconds
                anim.start();
                zoom_img1.startAnimation(animation2);
                zoom_img2.startAnimation(animation2);
                zoom_img3.startAnimation(animation);
                layoutparamslayoutparams.setMargins(0, 0, 0, 0);
                zoom_img1.setLayoutParams(layoutparamslayoutparams);
                layoutparamslayoutparams1.setMargins(0, 0, 0, 0);
                zoom_img2.setLayoutParams(layoutparamslayoutparams1);
                layoutparamslayoutparams2.setMargins(0, 0, 0, 15);
                zoom_img3.setLayoutParams(layoutparamslayoutparams2);
                viewPager.setCurrentItem(2, false);

            }
        });

        ViewTreeObserver viewTreeObserver = tab_block.getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                @Override
                public void onGlobalLayout() {

                    tab_block.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    viewHeight = tab_block.getHeight();
                    viewWeight = tab_block.getWidth();
                    transition_point = viewWeight / 3;
                    f = (float) transition_point;

                }
            });
        }

        if (viewPager.getCurrentItem() == 1) {
//    ObjectAnimator anim = ObjectAnimator.ofFloat(anim_img1,"x",f);
//    anim.setDuration(200); // duration 5 seconds
//    anim.start();
            LinearLayout.LayoutParams layoutparams = (LinearLayout.LayoutParams) anim_img1.getLayoutParams();
            layoutparams.leftMargin = 50;
            layoutparamslayoutparams2.setMargins(100, 0, 0, -4);
            zoom_img3.setLayoutParams(layoutparamslayoutparams2);
//    anim_img1.setLayoutParams(layoutparams);
        }
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                switch (position) {

                    case 0:
                        anim_img1.setVisibility(View.VISIBLE);
//                        anim_img2.setVisibility(View.INVISIBLE);
//                        anim_img3.setVisibility(View.INVISIBLE);
                        ObjectAnimator anim = ObjectAnimator.ofFloat(anim_img1, "x", 0);
                        anim.setDuration(200); // duration 5 seconds
                        anim.start();
                        zoom_img1.startAnimation(animation);
                        zoom_img2.startAnimation(animation2);
                        zoom_img3.startAnimation(animation2);
                        layoutparamslayoutparams.setMargins(0, 0, 0, 15);
                        zoom_img1.setLayoutParams(layoutparamslayoutparams);
                        layoutparamslayoutparams1.setMargins(0, 0, 0, 0);
                        zoom_img2.setLayoutParams(layoutparamslayoutparams1);
                        layoutparamslayoutparams2.setMargins(0, 0, 0, 0);
                        zoom_img3.setLayoutParams(layoutparamslayoutparams2);
                        break;

                    case 1:
                        anim_img1.setVisibility(View.VISIBLE);
//                        anim_img2.setVisibility(View.VISIBLE);
//                        anim_img3.setVisibility(View.INVISIBLE);
                        ObjectAnimator anim1 = ObjectAnimator.ofFloat(anim_img1, "x", f);
                        anim1.setDuration(200); // duration 5 seconds
                        anim1.start();

                        zoom_img1.startAnimation(animation2);
                        zoom_img2.startAnimation(animation);
                        zoom_img3.startAnimation(animation2);
                        layoutparamslayoutparams.setMargins(0, 0, 0, 0);
                        zoom_img1.setLayoutParams(layoutparamslayoutparams);
                        layoutparamslayoutparams1.setMargins(0, 0, 0, 15);
                        zoom_img2.setLayoutParams(layoutparamslayoutparams1);
                        layoutparamslayoutparams2.setMargins(0, 0, 0, 0);
                        zoom_img3.setLayoutParams(layoutparamslayoutparams2);
                        break;

                    case 2:
                        anim_img1.setVisibility(View.VISIBLE);
//                        anim_img2.setVisibility(View.INVISIBLE);
//                        anim_img3.setVisibility(View.VISIBLE);
                        ObjectAnimator anim2 = ObjectAnimator.ofFloat(anim_img1, "x", f * 2);
                        anim2.setDuration(200); // duration 5 seconds
                        anim2.start();
                        zoom_img1.startAnimation(animation2);
                        zoom_img2.startAnimation(animation2);
                        zoom_img3.startAnimation(animation);
                        layoutparamslayoutparams.setMargins(0, 0, 0, 0);
                        zoom_img1.setLayoutParams(layoutparamslayoutparams);
                        layoutparamslayoutparams1.setMargins(0, 0, 0, 0);
                        zoom_img2.setLayoutParams(layoutparamslayoutparams1);
                        layoutparamslayoutparams2.setMargins(0, 0, 0, 15);
                        zoom_img3.setLayoutParams(layoutparamslayoutparams2);
                        break;

                    default:
//                        anim_img1.setVisibility(View.INVISIBLE);
//                        anim_img2.setVisibility(View.VISIBLE);
//                        anim_img3.setVisibility(View.INVISIBLE);
                        break;
                }
            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {

                    case 0:
                        anim_img1.setVisibility(View.VISIBLE);
//                        anim_img2.setVisibility(View.INVISIBLE);
//                        anim_img3.setVisibility(View.INVISIBLE);
                        ObjectAnimator anim = ObjectAnimator.ofFloat(anim_img1, "x", 0);
                        anim.setDuration(200); // duration 5 seconds
                        anim.start();
                        zoom_img1.startAnimation(animation);
                        zoom_img2.startAnimation(animation2);
                        zoom_img3.startAnimation(animation2);
                        layoutparamslayoutparams.setMargins(0, 0, 0, 15);
                        zoom_img1.setLayoutParams(layoutparamslayoutparams);
                        layoutparamslayoutparams1.setMargins(0, 0, 0, 0);
                        zoom_img2.setLayoutParams(layoutparamslayoutparams1);
                        layoutparamslayoutparams2.setMargins(0, 0, 0, 0);
                        zoom_img3.setLayoutParams(layoutparamslayoutparams2);
                        break;

                    case 1:
                        anim_img1.setVisibility(View.VISIBLE);
//                        anim_img2.setVisibility(View.VISIBLE);
//                        anim_img3.setVisibility(View.INVISIBLE);
//                        LinearLayout.LayoutParams layoutParams=new LinearLayout.LayoutParams(, );
//                        ObjectAnimator anim1 = ObjectAnimator.ofFloat(anim_img1,"x",f);
//                        anim1.setDuration(200); // duration 5 seconds
//                        anim1.start();


                        zoom_img1.startAnimation(animation2);
                        zoom_img2.startAnimation(animation);
                        zoom_img3.startAnimation(animation2);
                        layoutparamslayoutparams.setMargins(0, 0, 0, 0);
                        zoom_img1.setLayoutParams(layoutparamslayoutparams);
                        layoutparamslayoutparams1.setMargins(0, 0, 0, 15);
                        zoom_img2.setLayoutParams(layoutparamslayoutparams1);
                        layoutparamslayoutparams2.setMargins(0, 0, 0, 0);
                        zoom_img3.setLayoutParams(layoutparamslayoutparams2);
                        break;

                    case 2:
                        anim_img1.setVisibility(View.VISIBLE);
//                        anim_img2.setVisibility(View.INVISIBLE);
//                        anim_img3.setVisibility(View.VISIBLE);
                        ObjectAnimator anim2 = ObjectAnimator.ofFloat(anim_img1, "x", f * 2);
                        anim2.setDuration(200); // duration 5 seconds
                        anim2.start();
                        zoom_img1.startAnimation(animation2);
                        zoom_img2.startAnimation(animation2);
                        zoom_img3.startAnimation(animation);
                        layoutparamslayoutparams.setMargins(0, 0, 0, 0);
                        zoom_img1.setLayoutParams(layoutparamslayoutparams);
                        layoutparamslayoutparams1.setMargins(0, 0, 0, 0);
                        zoom_img2.setLayoutParams(layoutparamslayoutparams1);
                        layoutparamslayoutparams2.setMargins(0, 0, 0, 15);
                        zoom_img3.setLayoutParams(layoutparamslayoutparams2);
                        break;

                    default:
//                        anim_img1.setVisibility(View.INVISIBLE);
//                        anim_img2.setVisibility(View.VISIBLE);
//                        anim_img3.setVisibility(View.INVISIBLE);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
       /* View root = tablayout.getChildAt(0);
        if (root instanceof LinearLayout) {
            ((LinearLayout) root).setShowDividers(LinearLayout.SHOW_DIVIDER_MIDDLE);
            GradientDrawable drawable = new GradientDrawable();
//            drawable.setColor(getResources().getColor(R.color.divider));
            drawable.setSize(1, 1);
            ((LinearLayout) root).setDividerPadding(1);
            ((LinearLayout) root).setDividerDrawable(drawable);
        }*/
        //viewPager.setSaveFromParentEnabled(false);
       /* viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        //Add fragment here
        viewPagerAdapter.AddFragment(new Fragment1(), "");
        viewPagerAdapter.AddFragment(new Fragment2(), "");
        viewPagerAdapter.AddFragment(new Fragment3(), "");
        viewPager.setAdapter(viewPagerAdapter);*/
        //tablayout.setupWithViewPager(viewPager);
        // setupTabIcons();
    }

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {

    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }

  /*  private void setupTabIcons() {
        tablayout.getTabAt(0).setIcon(tabIcons[0]);
        tablayout.getTabAt(1).setIcon(tabIcons[1]);
        tablayout.getTabAt(2).setIcon(tabIcons[2]);
    }*/

    private void init_slider() {
        toolbar = findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);


    }

    private void init_navigator() {

        // Navigation Drawer
        final int maxDrawerWidth = getResources().getDimensionPixelSize(R.dimen.sliding_drawer);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.main_activity_DrawerLayout);
        navigationView = (NavigationView) findViewById(R.id.navigation_view);
        contenLinView = (RelativeLayout) findViewById(R.id.contenLinView);

        // Init menu
        ImageView prof_pic = (ImageView) findViewById(R.id.img_pic);
        TextView tv_name = (TextView) findViewById(R.id.tv_name);
        TextView tv_email = (TextView) findViewById(R.id.tv_email);
        TextView tv_phone = (TextView) findViewById(R.id.tv_phone);
        TextView tv_proffesion = (TextView) findViewById(R.id.tv_proffesion);
        TextView tv_total_event_count = (TextView) findViewById(R.id.tv_total_event_count);
        TextView tv_total_event_invitation_count = (TextView) findViewById(R.id.tv_total_event_invitation_count);
        ImageView img_edit_camera = (ImageView) findViewById(R.id.img_pic);
        img_edit_camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mDrawerLayout.closeDrawers();
            }
        });

//        new Image_Loader(LoginActivity.this, R.drawable.login_menu_logo, R.drawable.login_menu_logo,
//                "", prof_pic, Transformation_Type.Typee.CropCircleTransformation, 20, 0, null);


        mActionBarDrawerToggle = new android.support.v7.app.ActionBarDrawerToggle
                (
                        this,
                        mDrawerLayout,
                        null,
                        R.string.app_name,
                        R.string.app_name
                ) {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                // Disables the burger/arrow animation by default
                super.onDrawerSlide(drawerView, slideOffset);

                float moveFactor = (navigationView.getLayoutParams().width * slideOffset);

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
                    contenLinView.setTranslationX(moveFactor);
                } else {
                    TranslateAnimation anim = new TranslateAnimation(lastTranslate, moveFactor, 0.0f, 0.0f);
                    anim.setDuration(0);
                    anim.setFillAfter(true);
                    contenLinView.startAnimation(anim);

                    lastTranslate = moveFactor;
                }

            }
        };

        mDrawerLayout.setDrawerListener(mActionBarDrawerToggle);
        if (getSupportActionBar() != null) {
            ///disable "hamburger to arrow" drawable
            customActionBar();
        }

        // Navigation Drawer layout width
        int possibleMinDrawerWidth = UtilsDevice.getScreenWidth(this) -
                UtilsMiscellaneous.getThemeAttributeDimensionSize(this, android.R.attr.actionBarSize);

        navigationView.getLayoutParams().width = Math.min(possibleMinDrawerWidth, maxDrawerWidth);



    }


    private void customActionBar() {
        ActionBar mActionBar = getSupportActionBar();
//        mActionBar.setHomeButtonEnabled(false);
//        mActionBar.setDisplayShowHomeEnabled(false);
//        mActionBar.setDisplayShowTitleEnabled(false);
//        mActionBar.setDisplayShowCustomEnabled(true);
//        mActionBar.setDisplayHomeAsUpEnabled(false);
        LayoutInflater mInflater = LayoutInflater.from(this);
        View mCustomView = mInflater.inflate(R.layout.topbar, null);
        lin_menu = (LinearLayout) mCustomView.findViewById(R.id.lin_menu);

        new Utils().hideCheck(lin_menu, ViewpagerActivity.this);
        lin_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!animatingRelativeLayout.isVisible()){
                    animatingRelativeLayout.show();

                }else{
                    animatingRelativeLayout.hide();

                }
               /* if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
                    mDrawerLayout.closeDrawer(GravityCompat.START);
                } else {
                    mDrawerLayout.openDrawer(GravityCompat.START);
                }*/
            }
        });


        mActionBar.setCustomView(mCustomView);
        mActionBar.setDisplayShowCustomEnabled(true);
    }
}
