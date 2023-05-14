package ru.intensive.dz2.dz02;

import java.util.concurrent.atomic.AtomicInteger;

public class Cat extends Animals {
    private static final AtomicInteger count = new AtomicInteger();

    public Cat() {
        super(
                characteristic.nextInt(200) + 100,
                0,
                characteristic.nextInt(4) + 2
        );
        count.incrementAndGet();
    }
    public static int getCount() {return count.get();}

    @Override
    public String toString() {
        return "Cat1{"+
                "runLimit=" + runLimit +
                ", swimLimit=" + swimLimit +
                ", leapLimit=" + leapLimit +
                "}";
    }
}