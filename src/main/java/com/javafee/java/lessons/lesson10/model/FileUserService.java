package com.javafee.java.lessons.lesson10.model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class FileUserService {
    public void save(List<String> data) throws IOException {
        Files.write(ConstansMessage.file.toPath(), data, StandardOpenOption.TRUNCATE_EXISTING);
    }

    public List<String> read() throws IOException {
        return Files.readAllLines(ConstansMessage.file.toPath());
    }
}
