package ru.intensive.dz9;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
class ObjectWithThreeFields {
    private String key1;
    private String key2;
    private String value;
}

public class ObjectWithThreeField {
    public static void main(String[] args) {
        Map<String, Map<String, String>> mp = new HashMap<>();

        mp.put("key1", new HashMap<>() {{
            put("Art1", "100");
            put("Max1", "200");
        }});

        mp.put("key2", new HashMap<>() {{
            put("Rita2", "300");
            put("Sasha2", "400");
            put("Igor2", "500");
        }});

        List<ObjectWithThreeFields> result = mp.entrySet().stream()
                .flatMap(outerEntry -> outerEntry.getValue().entrySet().stream()
                        .map(innerEntry -> new ObjectWithThreeFields(outerEntry.getKey(), innerEntry.getKey(), innerEntry.getValue())))
                .collect(Collectors.toList());
        // Вывод результатов
        result.forEach(obj ->
                System.out.println(obj.getKey1() + ", " + obj.getKey2() + ", " + obj.getValue()));

    }
}
