package com.udacity.talniya.util;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridLayout;

import android.widget.GridView;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import static android.widget.GridLayout.*;

/**
 * Created by talniya on 21/2/16.
 */



public class ImageAdapter extends BaseAdapter {

    private Context mContext;
    private String baseURL;


    public ImageAdapter(Context c) {
        mContext = c;
    }

    public int getCount() {
        return imgURL.length;
    }

    @Override
    public Object getItem(int position) {
        return imgURL[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }


    // create a new ImageView for each item referenced by the Adapter
    public View getView(final int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {  // if it's not recycled, initialize some attributes
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(GridLayout.LayoutParams.MATCH_PARENT,GridLayout.LayoutParams.WRAP_CONTENT));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(0, 0, 0, 0);

        } else {
            imageView = (ImageView) convertView;
        }

        Picasso.with(mContext).load( baseURL+ imgURL[position] ).into(imageView);



        return imageView;
    }

    public String[] getImgURL() {
        return imgURL;
    }

    public void setImgURL(String[] imgURL) {
        this.imgURL = imgURL;
    }

    public String getBaseURL() {
        return baseURL;
    }

    public void setBaseURL(String baseURL) {
        this.baseURL = baseURL;
    }

    // references to our images
    private String[] imgURL = {

    };




}