package com.javafee.java.lessons.lesson10;

import java.io.IOException;

public class Controller {
    private static UserService userService = new UserService();
    private static ViewImpl view = new ViewImpl();
    private SocialMedia facebook = new SocialMedia("Facebook");
    private SocialMedia instagram =  new SocialMedia("Instagram");

    public void run() throws IOException {
        showMenu();
    }

    public void showMenu() throws IOException {
        String choice = printMenu();
        while (!choice.equalsIgnoreCase("exit")){
            switch (choice){
                case "1" -> {
                    writeMessage();
                    choice = printMenu();
                }
                case "2" -> {
                    printMessages();
                    choice = printMenu();
                }
                case "exit" -> view.print("Exit");
                default -> {
                    view.print("Wrong choice");
                    choice = printMenu();
                }
            }
        }
    }

    private void printMessages() {
        String socialMedia = view.getString("Which social media messages do You want to see\n1 - Facebook\n2 - Instagram");
        if(socialMedia.equalsIgnoreCase("1"))
            facebook.printListMesaages();
        else if (socialMedia.equalsIgnoreCase("2"))
            instagram.printListMesaages();
        else
            view.print("Wrong choice in Social Media type.");
    }

    private void writeMessage() throws IOException {
        String name = view.getString("Give a nick/name");
        User user = userService.isExists(name) ? userService.getUser(name): userService.addUser(new User(name));
        String socialMedia = view.getString("1 - Facebook, 2 - Instagram");
        String messageFromUser = view.getString("Body message");
        if(socialMedia.equalsIgnoreCase("1"))
            user.sentMessage((message) -> facebook.sentMessage(message), messageFromUser );
        else if (socialMedia.equalsIgnoreCase("2"))
            user.sentMessage(message -> instagram.sentMessage(message), messageFromUser);
        else
            view.print("Wrong choice in Social Media type.");
    }

    private String printMenu() {
        return view.getString("Menu:\n1 - write message\n2 - print message\nExit");
    }
}
