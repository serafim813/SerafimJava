package ru.intensive.dz8;

import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

interface EqualsPredicate<T> {
    boolean test(T obj1, T obj2);
}

public class Main {
    public static void main(String[] args) {

        // Анонимный класс для поставщика
        Supplier<String> supplier2 = new Supplier<String>() {
            @Override
            public String get() {
                return "Hello, world!";
            }
        };
        String result5 = supplier2.get();
        System.out.println(result5); // Output: Hello, world!

        // Анонимный класс для предиката
        Predicate<Integer> predicate2 = new Predicate<Integer>() {
            @Override
            public boolean test(Integer num) {
                return num > 0;
            }
        };
        boolean result6 = predicate2.test(10);
        System.out.println(result6); // Output: true

        // Анонимный класс для потребителя
        Consumer<String> consumer2 = new Consumer<String>() {
            @Override
            public void accept(String text) {
                System.out.println(text);
            }
        };
        consumer2.accept("Hello, world!"); // Output: Hello, world!

        // Анонимный класс для функции
        Function<Integer, String> function2 = new Function<Integer, String>() {
            @Override
            public String apply(Integer num) {
                return "Number: " + num;
            }
        };
        String result7 = function2.apply(5);
        System.out.println(result7); // Output: Number: 5

        // Анонимный класс для компаратора
        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String str1, String str2) {
                return str1.compareTo(str2);
            }
        };

        int comparisonResult = comparator.compare("apple", "banana");
        System.out.println(comparisonResult); // Output: -1
    }
}
