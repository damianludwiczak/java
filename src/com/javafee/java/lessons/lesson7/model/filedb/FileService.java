package com.javafee.java.lessons.lesson7.model.filedb;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class FileService {
    public void save(List<String> data) throws IOException {
        Files.write(Constants.file.toPath(), data, StandardOpenOption.TRUNCATE_EXISTING);
    }

    public List<String> read() throws IOException {
        return Files.readAllLines(Constants.file.toPath());
    }
}
