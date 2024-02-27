package application;

import entities.Comment;
import entities.Post;

public class Main {
    public static void main(String[] args) {
        Post post1 = new Post("Traveling to New Zealand",
                "I'm going to visit this wonderful country!");
        post1.setLikes(12);
        post1.addComment(new Comment("Have a nice trip"));
        post1.addComment(new Comment("Wow that's awesome"));

        Post post2 = new Post("Good night guys",
                "See you tomorrow");
        post2.setLikes(5);
        post2.addComment(new Comment("Good night"));
        post2.addComment(new Comment("May the Force we with you"));

        System.out.println(post1);
        System.out.println(post2);

    }
}