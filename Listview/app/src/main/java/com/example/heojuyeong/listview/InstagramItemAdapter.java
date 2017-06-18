package com.example.heojuyeong.listview;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class InstagramItemAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Content> contents;

    public InstagramItemAdapter(ArrayList<Content> contents, Context context) {
        this.contents = contents;
        this.context = context;
    }

    @Override
    public int getCount() {
        return contents.size();
    }

    @Override
    public Object getItem(int position) {
        return contents.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //리스트한 열의 뷰를 갖고 옴
        View row = convertView;
        if (row == null) {
            LayoutInflater layoutInflater = ((Activity) context).getLayoutInflater();
            row = layoutInflater.inflate(R.layout.item_instragram_item, parent, false);
        }
        ImageView imageView = (ImageView) row.findViewById(R.id.contentImage);

        Picasso.with(context)
                .load("http://cfile6.uf.tistory.com/image/2707B63457974470040618")
                .centerCrop()
                .resize(300, 300)
                .into(imageView);
        //뷰에서 내용입력할 곳 찾음
        TextView userIdText = (TextView) row.findViewById(R.id.userId);
        Content content = contents.get(position);
        userIdText.setText(content.userId);

//        ListView listView2 = (ListView) row.findViewById(R.id.commentList);
//        //인덱스 돌아가면서 내용채움
//        listView2.setAdapter(content.getCommentAdapter());

        return row;
    }


}
