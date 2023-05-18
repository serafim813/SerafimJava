package ru.intensive.dz3;

public class InitExample {
    private static final String CONSTANT = getConstant();
    private String field = getField();

    public InitExample(String s) {
        System.out.println(s + " in constructor initialization");
    }

    static {
        System.out.println("Static initialization 1");
    }

    {
        System.out.println("Block initialization 1");
    }

    static {
        System.out.println("Static initialization 2");
    }

    {
        System.out.println("Block initialization 2");
    }

    private static String getConstant() {
        System.out.println("CONSTANT initialization");
        return "CONSTANT";
    }

    private String getField() {
        System.out.println("field initialization");
        return "field";
    }

    public static void main(String[] args) {
        new InitExample("FIRST");
        new InitExample("SECOND");
    }
}
