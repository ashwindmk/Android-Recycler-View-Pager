package com.example.ashwin.imagesviewpagerinrecyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<Image> imagesList = new ArrayList<>();
    private ArrayList<Product> productsList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new ProductsRecyclerViewAdapter(productsList, this);

        prepareImagesData();

        prepareProductsList();

        mRecyclerView.setAdapter(mAdapter);
    }

    private void prepareImagesData() {
        Image img = new Image(R.drawable.image1);
        imagesList.add(img);

        img = new Image(R.drawable.image2);
        imagesList.add(img);

        img = new Image(R.drawable.image3);
        imagesList.add(img);

        img = new Image(R.drawable.image4);
        imagesList.add(img);

        img = new Image(R.drawable.image5);
        imagesList.add(img);

        mAdapter.notifyDataSetChanged();
    }

    private void prepareProductsList()
    {
        Product product = new Product(imagesList);
        productsList.add(product);

        product = new Product(imagesList);
        productsList.add(product);

        product = new Product(imagesList);
        productsList.add(product);

        mAdapter.notifyDataSetChanged();
    }
}
