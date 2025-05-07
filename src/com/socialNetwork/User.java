package com.socialNetwork;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class User {
    private final int id;
    private String name;
    private String email;
    private String password;
    private Set<User> friends;
    private List<Post> posts;
    private Set<User> pendingFriendRequests;

    //constructor
    public User(int id, String name, String password, String email) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
        this.friends=new HashSet<>();
        this.posts=new ArrayList<>();
        this.pendingFriendRequests=new HashSet<>();
    }

    //Getters
    public int getId() {
        return id;
    }

    public Set<User> getFriends() {
        return friends;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public Set<User> getFriendRequests() {
        return pendingFriendRequests;
    }

    //add Friend
    public void addFriendRequest(User from){
        pendingFriendRequests.add(from);
    }

    public void removeFriendRequest(User from){
        friends.remove(from);
    }

    public boolean checkPassword(String pwd){
        return password.equals(pwd);
    }

    public void addPost(Post newPost) {
        posts.add(newPost);
    }

    public void addFriend(User from) {
        friends.add(from);
    }
}
