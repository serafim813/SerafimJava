package ru.intensive.dz5;

import java.util.logging.Level;
import java.util.logging.Logger;

public class GarbageCollectorExample {
    private static final Logger LOGGER = Logger.getLogger(GarbageCollectorExample.class.getName());

    public static void main(String[] args) {

        while (true) {
            Object obj = new Object(); // Создание объекта
            obj = null; // Удаление ссылки на объект


            // Сборка мусора
            System.gc();

            // Запись в логи
            LOGGER.info("Garbage Collector was run");

            try {
                Thread.sleep(1000); // ждем 1 секунду
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

//-Xlog:gc*:/Users/mac/Downloads/SerafimJava/src/main/java/ru/intensive/dz5/Tools/gc.log:time -XX:+PrintGCDetails