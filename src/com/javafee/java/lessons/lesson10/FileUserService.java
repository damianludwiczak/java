package com.javafee.java.lessons.lesson10;

import com.javafee.java.lessons.lesson7.model.filedb.Constants;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class FileUserService {
    public void save(List<String> data) throws IOException {
        Files.write(Constants.file.toPath(), data, StandardOpenOption.TRUNCATE_EXISTING);
    }

    public List<String> read() throws IOException {
        return Files.readAllLines(Constants.file.toPath());
    }
}
