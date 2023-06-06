package ru.intensive.dz7;

import java.util.Arrays;
import java.util.List;

public class ArrayList {

    public static <T> java.util.ArrayList<T> arrayToList(T[] array) {
        List<T> list = Arrays.asList(array);
        return new java.util.ArrayList<>(list);
    }
    public static <T> void swap(T[] array, int index1, int index2) {
        T temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    public static void main(String[] args) {
        String[] array = {"one", "two", "three", "four"};
        swap(array, 0, 2);
        System.out.println(Arrays.toString(array)); // выводит [three, two, one, four]
        Integer[] array_two = {1, 2, 3};
        java.util.ArrayList<Integer> list = arrayToList(array_two);
        System.out.println(list); // [1, 2, 3]
    }
}