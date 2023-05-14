package ru.intensive.dz2.dz02;

import java.util.concurrent.atomic.AtomicInteger;

public class Cat23 extends Animals{

    private static final AtomicInteger count = new AtomicInteger();

    public Cat23() {
        super(
                characteristic.nextInt(200) + 100,
                0,
                characteristic.nextInt(4) + 2
        );
        count.incrementAndGet();
    }

    public static int getCount() {
        return count.get();
    }

    @Override
    public String toString() {
        return "Cat{" +
                "runLimit=" + runLimit +
                ", swimLimit=" + swimLimit +
                ", leapLimit=" + leapLimit +
                '}';
    }
}
