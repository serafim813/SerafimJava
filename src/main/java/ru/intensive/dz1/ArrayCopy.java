package ru.intensive.dz1;

import java.util.Arrays;

public class ArrayCopy {
    public static void main(String[] args) {
        String[] origin = new String[]{"one", "two", "three"};
        String[] ArrayCopy = new String[3];
        System.arraycopy(origin, 0, ArrayCopy, 0, 3);
        System.out.println(Arrays.toString(origin));
        System.out.println(Arrays.toString(ArrayCopy));
    }
}
