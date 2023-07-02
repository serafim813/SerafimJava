package ru.intensive.dz5;

import java.util.logging.Level;
import java.util.logging.Logger;

public class GarbageCollectorExample {
    private static final Logger LOGGER = Logger.getLogger(GarbageCollectorExample.class.getName());

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        while (true) {
            Object obj = new Object(); // Создание объекта
            obj = null; // Удаление ссылки на объект


            // Сборка мусора каждую секунду
            if (System.currentTimeMillis() - startTime >= 1000) {
                System.gc();
                LOGGER.info("Garbage Collector was run");
                startTime = System.currentTimeMillis();
            }

            // Запись в логи
            LOGGER.info("Garbage Collector was run");

            try {
                Thread.sleep(10); // ждем 10 миллисекунд
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

//-Xlog:gc*:/Users/mac/Downloads/SerafimJava/src/main/java/ru/intensive/dz5/Tools/gc.log:time -XX:+PrintGCDetails