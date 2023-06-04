package ru.intensive.dz6.File.re;

import java.io.*;

public class FileCopyTest1 {
    public static void main(String[] args) throws IOException {
        File source = new File("test.txt");
        File dest = new File("dest.txt");

        long startTime = System.currentTimeMillis();

        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(source));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(dest));

        byte[] buffer = new byte[1024];
        int bytesRead;
        while ((bytesRead = bis.read(buffer)) != -1) {
            bos.write(buffer, 0, bytesRead);
        }

        bis.close();
        bos.close();

        long endTime = System.currentTimeMillis();
        long timeElapsed = endTime - startTime;

        System.out.println("Time taken to copy file using BufferedInputStream/BufferedOutputStream: " + timeElapsed + " milliseconds");
    }
}
