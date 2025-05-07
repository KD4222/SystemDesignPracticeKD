package com.socialNetwork;

import java.util.Date;

public class Post {
    private final int id;
    private final User author;
    private final String content;
    private final Date timeStamp;


    public Post(int id, User author, String content) {
        this.id = id;
        this.author = author;
        this.content = content;
        this.timeStamp = new Date();
    }

    public int getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public User getAuthor() {
        return author;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }
}
