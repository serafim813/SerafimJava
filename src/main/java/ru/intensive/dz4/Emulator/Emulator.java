package ru.intensive.dz4.Emulator;


import java.util.Random;

interface Method {
    void call();
}

class MyMethod implements Method {
    @Override
    public void call() {
        System.out.println("Hello World!");
    }
}

public class Emulator {
    public static void main(String[] args) {
        Method myMethod = new MyMethod();
        Method limitedMethod = new LimitedFrequencyMethodDecorator(myMethod, 10);

        Random random = new Random();
        while (true) {
            try {
                Thread.sleep((long) (random.nextDouble() * 1500 + 1500));
                limitedMethod.call();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
