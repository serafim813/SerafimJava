package ru.intensive.dz10;

import java.util.Random;

public class ThreadExample {
    public static void main(String[] args) {
        SharedData sharedData = new SharedData();

        Thread generatorThread = new Thread(new GeneratorTask(sharedData), "GeneratorThread");
        Thread[] consumerThreads = new Thread[3];
        for (int i = 0; i < consumerThreads.length; i++) {
            consumerThreads[i] = new Thread(new ConsumerTask(sharedData), "ConsumerThread-" + (i + 1));
        }

        generatorThread.start();
        for (Thread consumerThread : consumerThreads) {
            consumerThread.start();
        }

        try {
            Thread.sleep(10000); // Подождать 10 секунд
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        sharedData.setFinish(true); // Завершаем работу всех потоков
    }
}

class SharedData {
    private volatile int number; // Общедоступная переменная, которую используют потоки
    private volatile boolean finish; // Флаг для завершения работы потоков

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public boolean isFinish() {
        return finish;
    }

    public void setFinish(boolean finish) {
        this.finish = finish;
    }
}

class GeneratorTask implements Runnable {
    private final SharedData sharedData;
    private final Random random;

    public GeneratorTask(SharedData sharedData) {
        this.sharedData = sharedData;
        this.random = new Random();
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            int randomNumber = random.nextInt(100);
            sharedData.setNumber(randomNumber);
            System.out.println(Thread.currentThread().getName() + ": " + randomNumber);
            try {
                Thread.sleep(1000); // Подождать 1 секунду перед генерацией следующего числа
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        sharedData.setFinish(true); // Завершаем работу всех потоков
    }
}

class ConsumerTask implements Runnable {
    private final SharedData sharedData;

    public ConsumerTask(SharedData sharedData) {
        this.sharedData = sharedData;
    }

    @Override
    public void run() {
        while (!sharedData.isFinish()) {
            int number = sharedData.getNumber();
            System.out.println(Thread.currentThread().getName() + ": " + number);
            try {
                Thread.sleep(1000); // Подождать 1 секунду перед выводом следующего числа
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
