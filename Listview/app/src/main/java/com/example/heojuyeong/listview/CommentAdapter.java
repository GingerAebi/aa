package com.example.heojuyeong.listview;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by heojuyeong on 2017. 5. 27..
 */

public class CommentAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Comment> comments;

    public CommentAdapter(Context context, ArrayList<Comment> comments) {
        this.context = context;
        this.comments = comments;
    }

    @Override
    public int getCount() {
        return comments.size();
    }

    @Override
    public Object getItem(int position) {
        return comments.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;

        if (row == null) {
            LayoutInflater layoutInflater = ((Activity) context).getLayoutInflater();
            row = layoutInflater.inflate(R.layout.item_comment_list, parent, false);
        }
        Comment comment = comments.get(position);

        TextView commentUserIdText = (TextView) row.findViewById(R.id.userId);
        TextView commentText = (TextView) row.findViewById(R.id.comment);

        commentUserIdText.setText(comment.userId);
        commentText.setText(comment.comment);

        return row;
    }
}
