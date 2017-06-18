package com.example.heojuyeong.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        ListView listView = (ListView) findViewById(R.id.listView);
        ArrayList<Content> contents = new ArrayList<>();

        Content content = new Content("1번 유저");

        ArrayList<Comment> comments1 = new ArrayList<>();
        comments1.add(new Comment("1번 유저", "깔깔깔"));
        comments1.add(new Comment("2번 유저", "깔깔깔2"));
        comments1.add(new Comment("3번 유저", "깔깔깔3"));

//        content.setComments(comments1, new CommentAdapter(this, comments1));

        Content content2 = new Content("2번 유저");

        ArrayList<Comment> comments2 = new ArrayList<>();
        comments2.add(new Comment("1번 유저", "1깔깔깔3"));
        comments2.add(new Comment("2번 유저", "1깔깔깔12"));
        comments2.add(new Comment("3번 유저", "1깔깔깔13"));

//        content.setComments(comments2, new CommentAdapter(this, comments2));

        contents.add(content);
        contents.add(content2);

        InstagramItemAdapter instagramItemAdapter = new InstagramItemAdapter(contents, this);
        listView.setAdapter(instagramItemAdapter);

    }
}
