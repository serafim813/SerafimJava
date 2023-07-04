package ru.intensive.dz8;

@FunctionalInterface
interface ThreeFunction<T, U, V, R> {
    R apply(T arg1, U arg2, V arg3);
}

public class ThreeFunctionExample {
    public static void main(String[] args) {
        // Лямбда-выражение 1
        ThreeFunction<Integer, Integer, Integer, Integer> sum = (a, b, c) -> a + b + c;
        int result1 = sum.apply(1, 2, 3);
        System.out.println("Sum: " + result1); // Output: Sum: 6

        // Лямбда-выражение 2
        ThreeFunction<String, Integer, Integer, String> concatenate = (str, num1, num2) -> str + num1 + num2;
        String result2 = concatenate.apply("Result: ", 10, 20);
        System.out.println("Concatenated: " + result2); // Output: Concatenated: Result: 1020
    }
}

