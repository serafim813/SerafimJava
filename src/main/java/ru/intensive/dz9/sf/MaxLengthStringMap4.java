package ru.intensive.dz9.sf;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public class MaxLengthStringMap4 {
    public static void main(String[] args) {
        String[] strings = {"Astra", "Gorod Moskva", "River", "Ruslan", "Albatross"};

        BinaryOperator<String> func2 = (x1, x2) -> {
            if (x1 == null && x2.length() <= 10) {
                return x2;
            } else if (x1 == null && x2.length() > 10) {
                return null;
            } else if (x1.length() <= 10 && x2.length() <= 10) {
                return x1.length() > x2.length() ? x1 : x2;
            } else if (x1.length() <= 10 && x2.length() > 10) {
                return x1;
            } else {
                return x1.compareTo(x2) > 0 ? x1:x2;
            }
        };

        Map<Character, Optional<String>> resultMap = Arrays.stream(strings)
                .filter(str -> str.length() <= 10)
                .collect(Collectors.groupingBy(str -> str.charAt(0),
                        Collectors.reducing(func2)));

        // Проверка на отсутствие элементов длиной меньше 10 и установка значения null
        boolean hasLessThan10 = Arrays.stream(strings)
                .anyMatch(str -> str.length() < 10);

        // Установка resultMap в null, если нет элементов длиной меньше 10
        if (!hasLessThan10) {
            resultMap = null;
        }

        // Вывод результата
        if (resultMap != null) {
            resultMap.forEach((key, value) -> System.out.println("(" + key + ", " + value.orElse("") + ")"));
        } else {
            System.out.println(resultMap);
        }
    }
}
