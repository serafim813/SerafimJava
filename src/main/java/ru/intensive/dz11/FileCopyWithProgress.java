package ru.intensive.dz11;

import java.io.*;
import java.nio.channels.FileChannel;
import java.util.Scanner;

public class FileCopyWithProgress {
    private static volatile boolean isCopyInterrupted = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //System.out.print("Введите путь к исходному файлу: ");
        String sourcePath = "/Users/mac/Downloads/SerafimJava/src/main/java/ru/intensive/dz11/source.txt";

        //System.out.print("Введите путь к файлу назначения: ");
        String destinationPath = "/Users/mac/Downloads/SerafimJava/src/main/java/ru/intensive/dz11/destination.txt";

        Thread keyboardInputThread = new Thread(() -> {
            System.out.println("Введите 'quit' и нажмите Enter для прерывания копирования.");
            while (!isCopyInterrupted) {
                String input = scanner.nextLine();
                if (input.equalsIgnoreCase("quit")) {
                    isCopyInterrupted = true;
                    break;
                }
            }
        });
        keyboardInputThread.start();

        try {
            copyFileWithProgress(sourcePath, destinationPath);
        } catch (IOException e) {
            e.printStackTrace();
        }

        keyboardInputThread.interrupt();
    }

    private static void copyFileWithProgress(String sourcePath, String destinationPath) throws IOException {
        File sourceFile = new File(sourcePath);
        FileChannel sourceChannel = new FileInputStream(sourceFile).getChannel();
        long fileSize = sourceChannel.size();

        File destinationFile = new File(destinationPath);
        FileChannel destinationChannel = new FileOutputStream(destinationFile).getChannel();

        long transferredBytes = 0;
        long startTime = System.currentTimeMillis();

        try {
            while (transferredBytes < fileSize && !isCopyInterrupted) {
                long bytesToTransfer = Math.min(fileSize - transferredBytes, 1024); // Transfer in 1KB chunks
                transferredBytes += destinationChannel.transferFrom(sourceChannel, transferredBytes, bytesToTransfer);
                double progress = (double) transferredBytes / fileSize * 100;
                System.out.printf("\rПрогресс копирования: %.2f%%", progress);
            }
            System.out.println("\nКопирование завершено.");
        } finally {
            sourceChannel.close();
            destinationChannel.close();
        }
    }
}
