package ru.intensive.dz3;
import java.text.DecimalFormat;

public class MaskExample {
    private final int length;

    public MaskExample(int length) {
        this.length = length;
    }

    public String mapToMask(int number) {
        int numberLength = String.valueOf(number).length();
        if (numberLength > length) {
            return "Длина числа не может быть больше чем " + length;
        }
        DecimalFormat df = new DecimalFormat("00000000");
        String s = df.format(number);
        return s;
    }

    public static void main(String[] args) {
        MaskExample test = new MaskExample(8);
        System.out.println(test.mapToMask(123));
        System.out.println(test.mapToMask(54321));
        System.out.println(test.mapToMask(12345678));
        System.out.println(test.mapToMask(987654321));
    }
}
