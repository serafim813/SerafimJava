package ru.intensive.dz7;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        String[] words = {"apple", "orange", "banana", "pear", "apple", "grape", "mango", "banana", "kiwi", "peach", "orange"};

        // Найти и вывести список уникальных слов
        Set<String> uniqueWords = new HashSet<>(Arrays.asList(words));
        System.out.println("Уникальные слова: " + uniqueWords);

        // Посчитать, сколько раз встречается каждое слово
        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            if (wordCount.containsKey(word)) {
                wordCount.put(word, wordCount.get(word) + 1);
            } else {
                wordCount.put(word, 1);
            }
        }
        System.out.println("Количество повторений каждого слова: " + wordCount);
    }
}
