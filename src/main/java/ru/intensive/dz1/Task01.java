package ru.intensive.dz1;

import java.math.BigDecimal;

public class Task01 {
    public static void main(String[] args) {
        byte by = 0;
        short sh = 2434;
        int in = 343;
        long lo = 423;
        float fl = 5f;
        double db = 6d;
        boolean bl = true;
        char ch = 'a';
        BigDecimal bigDecimal = new BigDecimal(112);

        System.out.println(methodOne(2, 10, 20, 4));
        System.out.println("Сумма между 10 и 20: " + methodTwo(12, 3));
        System.out.println(methodThree(-12));
        System.out.println(methodFour(-12));
        System.out.println(methodFive("TestUser"));
        System.out.println(methodSix(22));
    }

    public static int methodOne(int a, int b, int c, int d) {
        return a * (b + (c / d));
    }

    public static boolean methodTwo(int a, int b) {
        return a + b >= 10 && a + b <= 20;
    }

    public static String methodThree(int a) {
        return a >= 0 ? "Положительное" : "Отрицательное";
    }

    public static boolean methodFour(int a) {
        return a < 0;
    }

    public static String methodFive(String name) {
        if (name != null && name.length() > 0) {
            return "Привет " + name + "!";
        } else {
         return "Имя не должно быть пустым!";
        }
    }

    public static boolean methodSix(int year) {
        return year % 400 == 0 || (year % 100 != 0 && (year % 4 == 0));
    }
}
