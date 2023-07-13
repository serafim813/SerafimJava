package ru.intensive.dz6.File;

import java.io.*;

import java.io.File;

public class FileReaderWriterCopy {
    public static void main(String[] args) {
        BufferedFileReaderWriterCopy(1024);
        BufferedFileReaderWriterCopy(4096);
        BufferedInputOutputStreamCopy(1024);
        BufferedInputOutputStreamCopy(4096);
        FileInputStreamOutputStreamCopy(1024);
        FileInputStreamOutputStreamCopy(4096);
        FileReaderWriterCopy(1024);
        FileReaderWriterCopy(4096);
        FileInputStreamCopy();

    }
    public static void BufferedFileReaderWriterCopy(int a) {
        File source = new File("test.txt");
        File dest = new File("copy.txt");
        try (BufferedReader reader = new BufferedReader(new FileReader(source));
             BufferedWriter writer = new BufferedWriter(new FileWriter(dest))) {
            long startTime = System.currentTimeMillis();
            char[] buffer = new char[a];
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
    public static void BufferedInputOutputStreamCopy(int a) {
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
    public static void FileInputStreamCopy() {
        File source = new File("image.jpg");
        File dest = new File("copy.jpg");
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
    public static void FileInputStreamOutputStreamCopy(int a) {
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
    public static void FileReaderCopy() {
        File source = new File("image.jpg");
        File dest = new File("copy.jpg");
        try (FileReader in = new FileReader(source);
             FileWriter out = new FileWriter(dest)) {
            long startTime = System.currentTimeMillis();
            char[] buffer = new char[1024];
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
    public static void FileReaderWriterCopy(int a) {
        File source = new File("test.txt");
        File dest = new File("copy.txt");
        try (FileReader reader = new FileReader(source);
             FileWriter writer = new FileWriter(dest)) {
            long startTime = System.currentTimeMillis();
            char[] buffer = new char[a];
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
