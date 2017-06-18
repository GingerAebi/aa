package com.example.heojuyeong.listview;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by heojuyeong on 2017. 6. 18..
 */

public class SearchItemAdapter extends ArrayAdapter<Content> {
    private Context context;
    private int resource;
    private List<Content> contents;

    public SearchItemAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<Content> contents) {
        super(context, resource, contents);

        this.context = context;
        this.resource = resource;
        this.contents = contents;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View row = convertView;
        if (row == null) {
            LayoutInflater layoutInflater = ((Activity) context).getLayoutInflater();
            row = layoutInflater.inflate(R.layout.item_instragram_item, parent, false);
        }
        ImageView imageView=(ImageView)row.findViewById(R.id.contentImage);
        Picasso.with(context).load("http://i.imgur.com/DvpvklR.png").into(imageView);
        //뷰에서 내용입력할 곳 찾음
        Content content = contents.get(position);


        return super.getView(position, convertView, parent);
    }
}
