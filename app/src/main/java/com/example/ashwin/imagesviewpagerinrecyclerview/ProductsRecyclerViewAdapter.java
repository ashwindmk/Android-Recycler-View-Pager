package com.example.ashwin.imagesviewpagerinrecyclerview;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.viewpagerindicator.CirclePageIndicator;

import java.util.ArrayList;

/**
 * Created by ashwin on 2/11/16.
 */

public class ProductsRecyclerViewAdapter extends RecyclerView.Adapter<ProductsRecyclerViewAdapter.MyViewHolder> {

    private ArrayList<Product> productsList;
    private Context context;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView mImageView;
        public ViewPager mViewPager;
        public CirclePageIndicator mIndicator;

        public MyViewHolder(View view) {
            super(view);
            mViewPager = (ViewPager) view.findViewById(R.id.pager);
            mIndicator = (CirclePageIndicator) view.findViewById(R.id.indicator);
        }
    }

    public ProductsRecyclerViewAdapter(ArrayList<Product> productsList, Context context) {
        this.productsList = productsList;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.products_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        createViewPager(holder, position);
    }

    @Override
    public int getItemCount() {
        return productsList.size();
    }


    private int currentPage = 0;

    private void createViewPager(MyViewHolder holder, int position)
    {
        int NUM_PAGES = 0;
        //private static final Integer[] IMAGES= {R.drawable.image1, R.drawable.image2, R.drawable.image3, R.drawable.image4};

        Product product = productsList.get(position);
        ArrayList<Image> imagesList = product.getImages();
        ArrayList<Integer> imagesRes = new ArrayList<>();
        for(Image image : imagesList)
        {
            imagesRes.add(image.getRes());
        }
        holder.mViewPager.setAdapter(new RecyclerViewPagerAdapter(context, imagesRes, currentPage));

        holder.mIndicator.setViewPager(holder.mViewPager);

        final float density = context.getResources().getDisplayMetrics().density;

        //Set circle indicator radius
        holder.mIndicator.setRadius(5 * density);

        NUM_PAGES = imagesRes.size();

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
        holder.mIndicator.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

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
