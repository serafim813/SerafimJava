package ru.intensive.dz6.File;


import java.io.File;
    import java.io.FileWriter;
    import java.io.IOException;
    import java.util.Random;

public class TextFileGenerator {
    public static void main(String[] args) {
        File file = new File("test.txt");
        try (FileWriter writer = new FileWriter(file)) {
            StringBuilder sb = new StringBuilder();
            Random random = new Random();
            for (int i = 0; i < 100000000; i++) {
                sb.append((char) (random.nextInt(94) + 32));
            }
            writer.write(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


