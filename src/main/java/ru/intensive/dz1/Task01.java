package ru.intensive.dz1;

import java.math.BigDecimal;

public class Task01 {
    public static void main(String[] args) {
        byte by = 1;
        short sh = 2;
        int in = 3;
        long lo = 4;
        float fl = 5f;
        double db = 6d;
        boolean bl = true;
        char ch = 'c';
        BigDecimal bigDecimal = new BigDecimal(7);

        System.out.println(methodOne(2, 10, 20, 4)); // result : 30
        System.out.println("Sum between 10 and 20: " + methodTwo(7, 8)); // result : true
        System.out.println(methodThree(-1)); // result : negative
        System.out.println(methodFour(-5)); // result : true
        System.out.println(methodFive("Пользователь"));
        System.out.println(methodSix(2024));
    }

    public static int methodOne(int a, int b, int c, int d) {
        return a * (b + (c / d));
    }

    public static boolean methodTwo(int a, int b) {
        return a + b >= 10 && a + b <= 20;
    }

    public static String methodThree(int a) {
        return a >= 0 ? "Positive" : "Negative";
    }

    public static boolean methodFour(int a) {
        return a < 0;
    }

    public static String methodFive(String name) {
        if (name != null && name.length() > 0) {
            return "Привет " + name + "!";
        } else {
         return "Имя не может быть пустым!";
        }
    }

    public static boolean methodSix(int year) {
        return year % 400 == 0 || (year % 100 != 0 && (year % 4 == 0));
    }
}
