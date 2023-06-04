package ru.intensive.dz6.File.sdf;

import java.io.*;

public class BufferedFileReaderWriterCopy {
    public static void BufferedFileReaderWriterCopy(String[] args) {
        File source = new File("test.txt");
        File dest = new File("copy.txt");
        try (BufferedReader reader = new BufferedReader(new FileReader(source));
             BufferedWriter writer = new BufferedWriter(new FileWriter(dest))) {
            long startTime = System.currentTimeMillis();
            char[] buffer = new char[1024];
            int len;
            while ((len = reader.read(buffer)) != -1) {
                writer.write(buffer, 0, len);
            }
            long endTime = System.currentTimeMillis();
            long duration = (endTime - startTime);
            System.out.println("Time taken: " + duration + " ms");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
