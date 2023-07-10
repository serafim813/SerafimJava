package ru.intensive.dz8;

import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Random;

//Сценарий а) Вставка 1000 элементов в начало списка:
//LinkedList время: 0 мс
//ArrayList время: 5 мс
//Сценарий б) Вставка 1000 элементов в конец списка:
//LinkedList время: 0 мс
//ArrayList время: 0 мс
//Сценарий в) Вставка 1000 элементов в середину списка:
//LinkedList время: 17 мс
//ArrayList время: 1 мс
//Сценарий г) Запрос 1000 раз рандомного элемента из списка:
//LinkedList время: 9 мс
//ArrayList время: 1 мс

public class ListComparison {
    public static void main(String[] args) {
        int listSize = 10000;
        LinkedList<Integer> linkedList = new LinkedList<>();
        ArrayList<Integer> arrayList = new ArrayList<>();

        // Заполнение списков
        for (int i = 0; i < listSize; i++) {
            linkedList.add(i);
            arrayList.add(i);
        }

        // Сценарии сравнения работы LinkedList и ArrayList
        scenarioA(linkedList, arrayList);
        scenarioB(linkedList, arrayList);
        scenarioC(linkedList, arrayList);
        scenarioD(linkedList, arrayList);
    }

    // Сценарий а) Вставка 1000 элементов в начало списка
    public static void scenarioA(LinkedList<Integer> linkedList, ArrayList<Integer> arrayList) {
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < 1000; i++) {
            linkedList.addFirst(-1);
        }

        long linkedListTime = System.currentTimeMillis() - startTime;

        startTime = System.currentTimeMillis();

        for (int i = 0; i < 1000; i++) {
            arrayList.add(0, -1);
        }

        long arrayListTime = System.currentTimeMillis() - startTime;

        System.out.println("Сценарий а) Вставка 1000 элементов в начало списка:");
        System.out.println("LinkedList время: " + linkedListTime + " мс");
        System.out.println("ArrayList время: " + arrayListTime + " мс");
    }

    // Сценарий б) Вставка 1000 элементов в конец списка
    public static void scenarioB(LinkedList<Integer> linkedList, ArrayList<Integer> arrayList) {
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < 1000; i++) {
            linkedList.addLast(-1);
        }

        long linkedListTime = System.currentTimeMillis() - startTime;

        startTime = System.currentTimeMillis();

        for (int i = 0; i < 1000; i++) {
            arrayList.add(-1);
        }

        long arrayListTime = System.currentTimeMillis() - startTime;

        System.out.println("Сценарий б) Вставка 1000 элементов в конец списка:");
        System.out.println("LinkedList время: " + linkedListTime + " мс");
        System.out.println("ArrayList время: " + arrayListTime + " мс");
    }

    // Сценарий в) Вставка 1000 элементов в середину списка
    public static void scenarioC(LinkedList<Integer> linkedList, ArrayList<Integer> arrayList) {
        int listSize = linkedList.size();

        long startTime = System.currentTimeMillis();

        for (int i = 0; i < 1000; i++) {
            linkedList.add(listSize / 2, -1);
        }

        long linkedListTime = System.currentTimeMillis() - startTime;

        startTime = System.currentTimeMillis();

        for (int i = 0; i < 1000; i++) {
            arrayList.add(listSize / 2, -1);
        }

        long arrayListTime = System.currentTimeMillis() - startTime;

        System.out.println("Сценарий в) Вставка 1000 элементов в середину списка:");
        System.out.println("LinkedList время: " + linkedListTime + " мс");
        System.out.println("ArrayList время: " + arrayListTime + " мс");
    }

    // Сценарий г) Запрос 1000 раз рандомного элемента из списка
    public static void scenarioD(LinkedList<Integer> linkedList, ArrayList<Integer> arrayList) {
        Random random = new Random();
        int listSize = linkedList.size();

        long startTime = System.currentTimeMillis();

        for (int i = 0; i < 1000; i++) {
            linkedList.get(random.nextInt(listSize));
        }

        long linkedListTime = System.currentTimeMillis() - startTime;

        startTime = System.currentTimeMillis();

        for (int i = 0; i < 1000; i++) {
            arrayList.get(random.nextInt(listSize));
        }

        long arrayListTime = System.currentTimeMillis() - startTime;

        System.out.println("Сценарий г) Запрос 1000 раз рандомного элемента из списка:");
        System.out.println("LinkedList время: " + linkedListTime + " мс");
        System.out.println("ArrayList время: " + arrayListTime + " мс");
    }
}
