package ru.intensive.dz1;

        import java.util.Formatter;

public class Formatter1 {
    public static void main(String[] args) {
        double number = 1234567.89;
        String moneyFormat = String.format("$%,.2f", number);
        moneyFormat = moneyFormat.replace(" ", ",");
        System.out.println(moneyFormat);
    }
}
