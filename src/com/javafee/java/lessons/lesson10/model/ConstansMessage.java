package com.javafee.java.lessons.lesson10.model;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ConstansMessage {
    public static String path = "usersSocialMedia.db";

    public static File file = new File(path);

    static {
        if (!file.exists()) {
            try {
                Files.createFile(Path.of(file.getPath()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
