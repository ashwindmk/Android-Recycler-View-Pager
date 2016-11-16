package com.example.ashwin.imagesviewpagerinrecyclerview;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.viewpagerindicator.CirclePageIndicator;

import java.util.ArrayList;

public class SelectedImageActivity extends AppCompatActivity
{
    private ViewPager mPager;
    private ArrayList<Integer> IMAGES = new ArrayList<>();
    private int page = 0, currentPage = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selected_image);

        Intent intent = getIntent();

        IMAGES = intent.getIntegerArrayListExtra("images");
        page = intent.getIntExtra("page", 0);

        mPager = (ViewPager) findViewById(R.id.selected_pager);

        mPager.setAdapter(new SelectedViewPagerAdapter(this, IMAGES, page));
        mPager.setCurrentItem(page);

        CirclePageIndicator indicator = (CirclePageIndicator) findViewById(R.id.selected_indicator);

        indicator.setViewPager(mPager);

        final float density = this.getResources().getDisplayMetrics().density;

        //Set circle indicator radius
        indicator.setRadius(5 * density);

        // Auto start of viewpager
        /*final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                if (currentPage == NUM_PAGES) {
                    currentPage = 0;
                }
                holder.mViewPager.setCurrentItem(currentPage++, true);
            }
        };
        Timer swipeTimer = new Timer();
        swipeTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(Update);
            }
        }, 3000, 3000);*/

        // Pager listener over indicator
        indicator.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int position) {
                currentPage = position;
            }

            @Override
            public void onPageScrolled(int pos, float arg1, int arg2) {

            }

            @Override
            public void onPageScrollStateChanged(int pos) {

            }
        });
    }
}
