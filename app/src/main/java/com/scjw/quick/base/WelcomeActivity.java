package com.scjw.quick.base;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.scjw.quick.MainActivity;
import com.scjw.quick.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by 蒋文龙 on 2018/6/25.
 * 引导页
 */

public class WelcomeActivity extends Activity {
    private ViewPager mPager;
    private View dot1, dot2, dot3;
    private List<View> dots;//小圆点集合
    private List<View> mViews;//引导页的view集合
    private PagerAdapter mAdapter;
    private TextView TvPass, TvHomepage;
    private int oldPosition = 0;//上个点
    private int mImg[] = {R.drawable.welcome_one, R.drawable.welcome_two, R.drawable.welcome_three};
    private Timer timer = new Timer();
    private int time = 0;

    TimerTask task = new TimerTask() {

        @Override

        public void run() {


            runOnUiThread(new Runnable() {      // UI thread

                @Override

                public void run() {
                    if (time < 2) {
                        mPager.setCurrentItem(mPager.getCurrentItem() + 1);
                        time++;
                    } else {
                        timer.cancel();
                    }
                }

            });

        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_layout);
        dots = new ArrayList<>();
        mViews = new ArrayList<View>();
        init();
    }


    private void init() {
        mPager = findViewById(R.id.pager);
        dot1 = findViewById(R.id.dot_1);
        dot2 = findViewById(R.id.dot_2);
        dot3 = findViewById(R.id.dot_3);
        TvPass = findViewById(R.id.pass);
        TvHomepage = findViewById(R.id.homepage);
        dots.add(dot1);
        dots.add(dot2);
        dots.add(dot3);
        dots.get(0).setBackgroundResource(R.drawable.dot_nomal);

        for (int i = 0; i < mImg.length; i++) {
            ImageView imageView = new ImageView(this);
            imageView.setBackgroundResource(mImg[i]);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);//这里
            mViews.add(imageView);
        }
        /**
         * 页卡适配器
         */
        mAdapter = new PagerAdapter() {
            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView(mViews.get(position));
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                View view = mViews.get(position);
                container.addView(view);
                return view;
            }

            @Override
            public boolean isViewFromObject(View arg0, Object arg1) {
                return arg0 == arg1;
            }

            @Override
            public int getCount() {
                return mViews.size();
            }
        };

        mPager.setAdapter(mAdapter);


        mPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {


            @Override
            public void onPageSelected(int position) {
                //下面就是获取上一个位置，并且把点的状体设置成默认状体
                dots.get(oldPosition).setBackgroundResource(R.drawable.dot_select);
                //获取到选中页面对应的点，设置为选中状态
                dots.get(position).setBackgroundResource(R.drawable.dot_nomal);
                //下面是记录本次的位置，因为在滑动，他就会变成过时的点了
                oldPosition = position;
                if (position == 2) {
                    TvPass.setVisibility(View.GONE);
                    TvHomepage.setVisibility(View.VISIBLE);
                    time = 99;
                }else
                    TvHomepage.setVisibility(View.GONE);
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
            }

            @Override
            public void onPageScrollStateChanged(int arg0) {

            }
        });


        TvPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(WelcomeActivity.this, MainActivity.class));
                finish();
            }
        });
        TvHomepage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(WelcomeActivity.this, MainActivity.class));
                finish();
            }
        });
        timer.schedule(task, 2000, 2000);

    }


}
