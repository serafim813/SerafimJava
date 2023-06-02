package ru.intensive.dz6.File;

import java.io.*;

public class FileCopyTest2 {
    public static void main(String[] args) {
        try {
            // Создаем файл
            File file = new File("test.txt");
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            // Генерируем текстовый файл размером 100 МБ
            for (int i = 0; i < 100000000; i++) {
                writer.write((char) (Math.random() * 94 + 32));
            }
            writer.close();
            // Копируем файл с помощью BufferedInputStream и BufferedOutputStream
            long start = System.currentTimeMillis();
            FileInputStream inputStream = new FileInputStream(file);
            FileOutputStream outputStream = new FileOutputStream("copy.txt");
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
            byte[] buffer = new byte[1024]; // Размер массива - 1 КБ
            int bytesRead;
            while ((bytesRead = bufferedInputStream.read(buffer)) != -1) {
                bufferedOutputStream.write(buffer, 0, bytesRead);
            }
            bufferedOutputStream.flush();
            bufferedInputStream.close();
            bufferedOutputStream.close();
            long end = System.currentTimeMillis();
            System.out.println("Время копирования при размере массива 1 КБ: " + (end - start) + " мс");

            // Копируем файл с помощью BufferedInputStream и BufferedOutputStream, увеличивая размер массива
            start = System.currentTimeMillis();
            inputStream = new FileInputStream(file);
            outputStream = new FileOutputStream("copy2.txt");
            bufferedInputStream = new BufferedInputStream(inputStream);
            bufferedOutputStream = new BufferedOutputStream(outputStream);
            buffer = new byte[1048576]; // Размер массива - 1 МБ
            while ((bytesRead = bufferedInputStream.read(buffer)) != -1) {
                bufferedOutputStream.write(buffer, 0, bytesRead);
            }
            bufferedOutputStream.flush();
            bufferedInputStream.close();
            bufferedOutputStream.close();
            end = System.currentTimeMillis();
            System.out.println("Время копирования при размере массива 1 МБ: " + (end - start) + " мс");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
