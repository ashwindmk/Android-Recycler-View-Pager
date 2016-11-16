package com.example.ashwin.imagesviewpagerinrecyclerview;

import java.util.ArrayList;

/**
 * Created by ashwin on 8/11/16.
 */

public class Product
{
    ArrayList<Image> images = new ArrayList<>();

    public Product(ArrayList<Image> images)
    {
        this.images = images;
    }

    public ArrayList<Image> getImages()
    {
        return this.images;
    }

    public void setImages(ArrayList<Image> images)
    {
        this.images = images;
    }
}
