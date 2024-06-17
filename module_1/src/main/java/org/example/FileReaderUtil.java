package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileReaderUtil {
    public String readFileAsString(String filePath) throws IOException {
        return new String(Files.readAllBytes(Paths.get(filePath)));
    }

    public String readResourcesFile() throws IOException {
        return new String(Files.readAllBytes(Paths.get("src\\main\\resources\\text.txt")));
    }
}
