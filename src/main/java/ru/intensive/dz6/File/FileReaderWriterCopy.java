package ru.intensive.dz6.File;

import java.io.*;


public class FileReaderWriterCopy {
    public static void main(String[] args) {
        File source = new File("test.txt");
        File dest = new File("copy.txt");
        try (FileReader reader = new FileReader(source);
             FileWriter writer = new FileWriter(dest)) {
            char[] buffer = new char[1024];
            int len;
            while ((len = reader.read(buffer)) != -1) {
                writer.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
