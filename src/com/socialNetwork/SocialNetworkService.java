package com.socialNetwork;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SocialNetworkService {
    Map<Integer,User> usersById=new HashMap<>();
    Map<String,User> usersByEmail=new HashMap<>();
    private int userIdCounter=1;
    private int postIdCounter=1;

    //User Registration
    public User register(String name,String email,String password){
        if(usersByEmail.containsKey(email)){
            throw new IllegalArgumentException("Email already registered.");
        }
        User newUser=new User(userIdCounter++,name,email,password);
        usersById.put(newUser.getId(), newUser);
        usersByEmail.put(newUser.getEmail(), newUser);
        return newUser;
    }

    //user Login
    public User login(String email,String password) {
        User user = usersByEmail.get(email);
        if(user!=null && user.checkPassword(password)){
            return user;
        }
        throw new IllegalArgumentException();
    }
    //send a friend Request
    public void sendFriendRequest(User from,User to){
        if(from.equals(to))throw new IllegalArgumentException("Cannot send request to self");
        to.addFriendRequest(from);
    }

    //accept a friend request
    public void acceptFriendRequest(User user,User from){
        if(user.getFriendRequests().contains(from)){
            user.addFriend(from);
            from.addFriend(user);
            user.removeFriendRequest(from);
        }else throw new IllegalArgumentException("Already Sent to this user.");
    }

    //posting
    public Post createPost(User user,String content){
        Post post=new Post(postIdCounter++,user,content);
        user.addPost(post);
        return post;
    }

    //News feed
    public List<Post>getNewsFeed(User user){
        List<Post> feed=new ArrayList<>();
        for(User friend:user.getFriends()){
            feed.addAll(friend.getPosts());
        }
        feed.sort((a,b)->b.getTimeStamp().compareTo(a.getTimeStamp()));
        return feed;
    }
}
