package com.example.ashwin.imagesviewpagerinrecyclerview;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by ashwin on 8/11/16.
 */

public class RecyclerViewPagerAdapter extends PagerAdapter
{
    private ArrayList<Integer> IMAGES;
    private int page = 0;
    private LayoutInflater inflater;
    private Context context;

    public RecyclerViewPagerAdapter(Context context, ArrayList<Integer> IMAGES, int page) {
        this.context = context;
        this.IMAGES = IMAGES;
        this.page = page;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        return IMAGES.size();
    }

    @Override
    public Object instantiateItem(ViewGroup view, final int position) {

        inflater = (LayoutInflater) view.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View imageLayout = inflater.inflate(R.layout.slidingimages_layout, view, false);

        assert imageLayout != null;
        final ImageView imageView = (ImageView) imageLayout
                .findViewById(R.id.image);

        imageView.setImageResource(IMAGES.get(position));

        imageLayout.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                int p = position+1;
                Toast.makeText(context, "image " + p + " is clicked", Toast.LENGTH_LONG).show();
                Intent intent = new Intent( v.getContext(), SelectedImageActivity.class);
                intent.putExtra("images", IMAGES);
                //now you known which Page is clicked, you can do what you want
                intent.putExtra("page", position);
                context.startActivity(intent);
            }
        });

        view.addView(imageLayout, 0);

        return imageLayout;
    }

    @Override
    public boolean isViewFromObject(View view, Object object)
    {
        return view.equals(object);
    }

    @Override
    public void restoreState(Parcelable state, ClassLoader loader) {
    }

    @Override
    public Parcelable saveState()
    {
        return null;
    }

}
