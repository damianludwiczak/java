package com.javafee.java.lessons.lesson9;

import java.util.Random;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        BBC bbc = new BBC("BBC");
        CNN cnn = new CNN("CNN");
        SkyNews skyNews = new SkyNews("SkyNews");

        Broadcaster facebook = new Broadcaster("Facebook");
        Broadcaster redit = new Broadcaster("Redit");

        // more than broadcaster
        // displaying the broadcaster name and no of news in the feed
        // displaying the news in some diff duration for each agencies using some condition f.eg.: if(i % 7 == 0 || i % 8 == 0) ...
        // add sleep in the loop (Thread.sleep(new Random().nextInt(1200) + 300);)

        bbc.createNews(facebook::broadcast);
        cnn.createNews(facebook::broadcast);
        skyNews.createNews(facebook::broadcast);

        for (int i = 0; i < 300; i++) {
            if (i % 3 == 0) {
                if (i % 7 == 0)
                    cnn.createNews(redit::broadcast);
                else if (i % 8 == 0)
                    skyNews.createNews(redit::broadcast);
                else
                    bbc.createNews(redit::broadcast);
            } else {
                if (i % 7 == 0)
                    cnn.createNews(facebook::broadcast);
                else if (i % 8 == 0)
                    skyNews.createNews(facebook::broadcast);
                else
                    bbc.createNews(facebook::broadcast);
            }

            Thread.sleep(new Random().nextInt(1200) + 300);
        }
    }
}
