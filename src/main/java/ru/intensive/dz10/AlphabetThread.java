package ru.intensive.dz10;

public class AlphabetThread {
    public static void main(String[] args) {
        int numThreads = 5; // Количество потоков (букв)
        int repetitions = 3; // Количество повторений каждой буквы

        Object lock = new Object(); // Объект блокировки для синхронизации потоков
        for (int i = 0; i < numThreads; i++) {
            char letter = (char) ('A' + i);
            Thread thread = new Thread(new LetterTask(letter, repetitions, numThreads, lock));
            thread.start();
        }
    }
}

class LetterTask implements Runnable {
    private final char letter;
    private final int repetitions;
    private final int numThreads;
    private final Object lock;

    private static volatile char currentLetter = 'A'; // Общая переменная для синхронизации букв

    public LetterTask(char letter, int repetitions, int numThreads, Object lock) {
        this.letter = letter;
        this.repetitions = repetitions;
        this.numThreads = numThreads;
        this.lock = lock;
    }

    @Override
    public void run() {
        try {
            synchronized (lock) {
                for (int i = 0; i < repetitions; i++) {
                    while (letter != currentLetter) {
                        lock.wait(); // Поток ждет, пока не придет его очередь
                    }

                    System.out.println(letter); // Выводим букву
                    currentLetter = (char) ((currentLetter - 'A' + 1) % numThreads + 'A'); // Переходим к следующей букве
                    lock.notifyAll(); // Уведомляем все потоки, чтобы они проверили свои условия
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
