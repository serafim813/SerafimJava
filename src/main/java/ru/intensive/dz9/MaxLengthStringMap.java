package ru.intensive.dz9;

import java.util.HashMap;
import java.util.Map;

public class MaxLengthStringMap {
    public static void main(String[] args) {
        String[] strings = {"Astra", "Gorod Moskva", "River", "Ruslan", "Albatross"};

        Map<String, String> resultMap = new HashMap<>();

        for (String str : strings) {
            String firstLetter = str.substring(0, 1);
            String currentMaxString = resultMap.get(firstLetter);

            if (currentMaxString == null || (str.length() > currentMaxString.length() && str.length() <= 10)) {
                resultMap.put(firstLetter, str);
            }
        }

        // Вывод результата
        for (Map.Entry<String, String> entry : resultMap.entrySet()) {
            System.out.println("(" + entry.getKey() + ", " + entry.getValue() + ")");
        }
    }
}
