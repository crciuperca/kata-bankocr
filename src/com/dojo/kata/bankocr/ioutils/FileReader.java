package com.dojo.kata.bankocr.ioutils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class FileReader {
    private String filePathString;

    public FileReader(String filePathString) {
        this.filePathString = filePathString;
    }

    public List<String> getLines() {
        List<String> lines = new ArrayList<>();
        try (Stream<String> stream = Files.lines(Paths.get(filePathString))) {
            stream.forEach(line -> lines.add(line));
        } catch (IOException e) {
            System.out.println("File inaccessible at path: " + filePathString);
            System.exit(1);
        }
        return lines;
    }
}
