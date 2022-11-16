package com.javafee.java.lessons.lesson10;

public class Main {
    public static void main(String[] args) {
        View view = new View();

        User user = new User("Jakub");
        User user1 = new User("Damian");

        SocialMedia facebook =  new SocialMedia("Facebook");
        SocialMedia instagram =  new SocialMedia("Instagram");


        for (int i = 1; i < 20; i++) {
            String messageUser = view.getString("Write message");
            user1.sentMessage((message) -> facebook.sentMessage(message), messageUser);

            user.sentMessage((message) -> facebook.sentMessage(message), messageUser);
            user1.sentMessage((message) -> instagram.sentMessage(message), messageUser);
            user.sentMessage((message) -> instagram.sentMessage(message), messageUser);
        }
    }
}
