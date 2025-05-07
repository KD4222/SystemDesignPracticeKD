package com.socialNetwork;

import java.util.List;

public class SocialNetworkDemo {
    public static void main(String[] args) {
        System.out.println("HELLO,welcome to the social network.");
        SocialNetworkService sns=new SocialNetworkService();

        User sumit=sns.register("Sumit Sarcar","sumitji@gmail.com","passKeyHere");
        User archi=sns.register("Archana Tomar","archana@gmail.com","secondPassKey");

        sns.sendFriendRequest(sumit,archi);
        sns.acceptFriendRequest(archi,sumit);

        sns.createPost(archi,"Watching The Diplomat at PVR with friends.");
        sns.createPost(sumit,"Say hi, just joined the socialNetwork folks!");

        List<Post> archiFeed=sns.getNewsFeed(archi);
        for(Post post: archiFeed){
            System.out.println(post.getAuthor().getName() + " : "+post.getContent());
        }
    }
}
