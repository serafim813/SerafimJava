package ru.intensive.dz8;

import java.util.Comparator;
import java.util.TreeMap;

public class CustomComparatorExample {
    public static void main(String[] args) {
        // Создание TreeMap с кастомным компаратором
        TreeMap<String, Integer> treeMap = new TreeMap<>(new CustomComparator());

        // Добавление элементов в TreeMap
        treeMap.put("abc", 1);
        treeMap.put("abcd", 2);
        treeMap.put("ab", 3);
        treeMap.put("a", 4);

        // Вывод элементов TreeMap с использованием forEach
        treeMap.forEach((key, value) -> System.out.println(key + ": " + value));
    }

    // Кастомный компаратор
    static class CustomComparator implements Comparator<String> {
        @Override
        public int compare(String str1, String str2) {
            // Сначала сравниваем по длине строк
            int lengthComparison = Integer.compare(str1.length(), str2.length());

            if (lengthComparison != 0) {
                // Если длины разные, возвращаем результат сравнения по длине
                return lengthComparison;
            } else {
                // Если длины одинаковые, возвращаем результат сравнения по алфавитному порядку
                return str1.compareTo(str2);
            }
        }
    }
}
