package ru.intensive.dz9;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MaxLengthStringMap {
    public static void main(String[] args) {
        String[] strings = {"Astra", "Gorod Moskva", "River 11111111", "Ruslan 444444444", "Albatross 11111111"};

        Stream<String> streamStr = Stream.of(strings);

        BinaryOperator<String> func2 = (x1, x2) -> {
            if (x1 == null && x2.length() <= 10) {
                return x2;
            } else if (x1 == null && x2.length() > 10) {
                return null;
            } else if (x1.length() <= 10 && x2.length() <= 10) {
                return x1.length() > x2.length() ? x1 : x2;
            } else if (x1.length() <= 10 && x2.length() > 10) {
                return x1;
            } else if (x1.length() > 10 && x2.length() > 10) {
                return null;
            } else if (x1.length() > 10 && x2.length() <= 10) {
                return x2;
            } else {
                return null;
            }
        };

        Optional<String> result = streamStr.collect(Collectors.reducing(func2));

        Map<Character, Optional<String>> resultMap = Arrays.stream(strings)
                .collect(Collectors.groupingBy(str -> str.charAt(0),
                        Collectors.reducing(func2)));


        resultMap.entrySet().stream().forEach(e -> {
            if (e.getValue().isPresent() && e.getValue().get().length() > 10) {
                e.setValue(Optional.empty());
            }
        });
        System.out.println(resultMap);

    }
}
