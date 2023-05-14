package ru.intensive.dz4;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class regex {
    public static void main(String[] args) {
        String text = "<html><head><title>Заголовок</title></head><body><h1 class=\"офмф\">Привет, мир!</h1></body></html>";
        Pattern pattern = Pattern.compile("<[^>]+>");
        Matcher matcher = pattern.matcher(text);
        System.out.println("Найденные теги:");
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
