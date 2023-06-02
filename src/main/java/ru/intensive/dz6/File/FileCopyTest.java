package ru.intensive.dz6.File;

import java.io.*;

public class FileCopyTest {
    public static void main(String[] args) throws IOException {
        File source = new File("test.txt");
        File dest = new File("text_copy.txt");

        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(source));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(dest));

        byte[] buffer = new byte[1024];
        int bytesRead;
        while ((bytesRead = bis.read(buffer)) != -1) {
            bos.write(buffer, 0, bytesRead);
        }

        bis.close();
        bos.close();
    }
}
