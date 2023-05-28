package ru.intensive.dz4;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExampleRegex {

    public static void main(String[] args) {
        System.out.println("1. Проверить что строка состоит из буквенно-числовых символов " +
                "и знаков подчеркивания(язык английский)");
        System.out.println("123_abc");
        System.out.println(methodOne("123_abc"));
        System.out.println("123$abc");
        System.out.println(methodOne("123$abc"));
        System.out.println(System.lineSeparator());


        System.out.println("2. Проверить что строка состоит из английских букв в нижнем регистре," +
                "соединенных подчеркиванием примеры допустимых записей:");
        System.out.println("java_exercises");
        System.out.println(methodTwo("java_exercises"));
        System.out.println("java_exercises_double");
        System.out.println(methodTwo("java_exercises_double"));
        System.out.println("privet_");
        System.out.println(methodTwo("privet_"));
        System.out.println("privet_privet_");
        System.out.println(methodTwo("privet_privet_"));
        System.out.println(System.lineSeparator());


        System.out.println("3. Проверить что строка содержит букву g, но при этом она не является началом," +
                " или концом ни одного из слов в строке");
        System.out.println("stay good");
        System.out.println(methodThree("stay good"));
        System.out.println("werwer");
        System.out.println(methodThree("werwer"));
        System.out.println("gerw");
        System.out.println(methodThree("gerw"));
        System.out.println("werg");
        System.out.println(methodThree("werg"));
        System.out.println("sage");
        System.out.println(methodThree("sage"));
        System.out.println(System.lineSeparator());


        System.out.println("4. Написать программу извлекающую из текста все html - теги");
        System.out.println(methodFour("<p>Hello <code>Everybody</code> nice to meet u Hope to see u soon.</p>"));
        System.out.println(System.lineSeparator());

        System.out.println("5. Написать программу проверяющую, является ли входная строка email адресом");
        System.out.println("test@test.ru");
        System.out.println(methodFive("test1@test.ru"));
        System.out.println("test12@test_test.ru");
        System.out.println(methodFive("test@test_test.ru"));
        System.out.println(System.lineSeparator());

        System.out.println("6. Напишите программу, которая принимает на вход число и выводит его в денежном формате.");
        System.out.println("1234567.89");
        System.out.println(methodSix(1234567.89));
        System.out.println(System.lineSeparator());
    }

    public static boolean methodOne(String string) {
        return string.matches("^[a-zA-Z0-9_]+$");
    }

    public static boolean methodTwo(String string) {
        return string.matches("([a-z+]+_[a-z+]+)+");
    }

    public static boolean methodThree(String string) {
        String pattern = "\\B[gG]\\B";
        return Pattern.compile(pattern).matcher(string).find();
    }

    public static List<String> methodFour(String string) {
        List<String> al = new ArrayList<>();
        String pattern = "<.*?>";
        Matcher matcher = Pattern.compile(pattern).matcher(string);
        while(matcher.find()) {
            al.add(matcher.group());
        }
        return al;
    }

    public static boolean methodFive(String string) {
        Pattern pattern = Pattern.compile("^[a-zA-Z0-9._-]+@[a-zA-Z0-9-]+\\.[a-zA-Z]{2,3}$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(string);
        return matcher.matches();
    }

    public static String methodSix(double value) {
        Locale locale = Locale.US;
                String pattern = "$%,.2f";
                return String.format(locale, pattern, value);
            }
        }