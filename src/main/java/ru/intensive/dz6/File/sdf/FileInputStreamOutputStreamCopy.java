package ru.intensive.dz6.File.sdf;

import java.io.*;


public class FileInputStreamOutputStreamCopy {
    public static void FileInputStreamOutputStreamCopy(String[] args) {
        File source = new File("test.txt");
        File dest = new File("copy.txt");
        try (FileInputStream in = new FileInputStream(source);
             FileOutputStream out = new FileOutputStream(dest)) {
            long startTime = System.currentTimeMillis();
            byte[] buffer = new byte[1024];
            int len;
            while ((len = in.read(buffer)) != -1) {
                out.write(buffer, 0, len);
            }
            long endTime = System.currentTimeMillis();
            long duration = (endTime - startTime);
            System.out.println("Time taken: " + duration + " ms");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
