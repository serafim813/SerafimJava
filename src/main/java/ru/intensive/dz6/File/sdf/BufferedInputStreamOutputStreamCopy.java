package ru.intensive.dz6.File.sdf;

import java.io.*;


public class BufferedInputStreamOutputStreamCopy {
    public static void BufferedInputStreamOutputStreamCopy(String[] args) {
        File source = new File("test.txt");
        File dest = new File("copy.txt");
        try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(source));
             BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(dest))) {
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
