package com.javafee.java.lessons.lesson7.model.filedb;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class FileUserService {
    public void Save(List<String> data) throws IOException {
        Files.write(ConstansUsers.file.toPath(), data, StandardOpenOption.TRUNCATE_EXISTING);
    }

    public List<String> read() throws IOException{
        return Files.readAllLines(ConstansUsers.file.toPath());
    }
}
