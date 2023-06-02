package ru.intensive.dz6.File;

import java.io.*;

public class FileReaderCopy {
    public static void main(String[] args) {
        File source = new File("image.jpg");
        File dest = new File("copy.jpg");
        try (FileReader in = new FileReader(source);
             FileWriter out = new FileWriter(dest)) {
            char[] buffer = new char[1024];
            int len;
            while ((len = in.read(buffer)) != -1) {
                out.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

