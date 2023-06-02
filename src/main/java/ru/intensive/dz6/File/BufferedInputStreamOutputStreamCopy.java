package ru.intensive.dz6.File;

import java.io.*;


public class BufferedInputStreamOutputStreamCopy {
    public static void main(String[] args) {
        File source = new File("test.txt");
        File dest = new File("copy.txt");
        try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(source));
             BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(dest))) {
            byte[] buffer = new byte[1024];
            int len;
            while ((len = in.read(buffer)) != -1) {
                out.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
