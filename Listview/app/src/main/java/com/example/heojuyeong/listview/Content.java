package com.example.heojuyeong.listview;

import java.util.ArrayList;


public class Content {

    public String profileImageUrl;
    public String userId;
    public String menuButtonUrl;
    public String contentImageUrl;
    public String likeImageUrl;
    public String commentImageUrl;
    public String messageImageUrl;
    public String bookImageUrl;
    ArrayList<Comment> comments;
    CommentAdapter commentAdapter;

    public Content(String profileImageUrl, String userId, String menuButtonUrl, String contentImageUrl, String likeImageUrl, String commentImageUrl, String messageImageUrl, String bookImageUrl) {
        this.profileImageUrl = profileImageUrl;
        this.userId = userId;
        this.menuButtonUrl = menuButtonUrl;
        this.contentImageUrl = contentImageUrl;
        this.likeImageUrl = likeImageUrl;
        this.commentImageUrl = commentImageUrl;
        this.messageImageUrl = messageImageUrl;
        this.bookImageUrl = bookImageUrl;
    }

    public Content(String userId) {
        this("", userId, "", "", "", "", "", "");
    }

    public void setComments(ArrayList<Comment> comments, CommentAdapter commentAdapter)
    {
        this.commentAdapter = commentAdapter;
        this.comments = comments;
    }

    public CommentAdapter getCommentAdapter() {
        return commentAdapter;
    }
}
