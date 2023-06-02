package ru.intensive.dz6.File;

import java.io.*;

public class BufferedFileReaderWriterCopy {
    public static void main(String[] args) {
        File source = new File("test.txt");
        File dest = new File("copy.txt");
        try (BufferedReader reader = new BufferedReader(new FileReader(source));
             BufferedWriter writer = new BufferedWriter(new FileWriter(dest))) {
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
