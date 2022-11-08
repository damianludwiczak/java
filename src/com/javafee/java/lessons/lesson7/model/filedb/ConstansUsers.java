package com.javafee.java.lessons.lesson7.model.filedb;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ConstansUsers {
    public static String path = "users.db";
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
