package org.example;

import java.io.FileWriter;
import java.io.IOException;


public class FileWriterUtil {
    public void writeStringToFile(String content, String filePath) throws IOException {
        FileWriter writer = new FileWriter(filePath);
        writer.write(content);
        writer.close();
    }
}
