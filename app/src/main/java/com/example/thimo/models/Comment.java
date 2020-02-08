package com.example.thimo.models;

public class Comment {
    String userName;
    String userComment;

    public Comment() {}

    public Comment(String userName, String userComment) {
        this.userName = userName;
        this.userComment = userComment;
    }

    public String getUserName() {
        return this.userName;
    }

    public String getUserComment() {
        return this.userComment;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserComment(String userComment) {
        this.userComment = userComment;
    }
}
