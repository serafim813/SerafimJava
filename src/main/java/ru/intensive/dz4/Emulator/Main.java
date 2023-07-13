package ru.intensive.dz4.Emulator;


import java.util.Random;

public class Main {

    public static void main(String[] args) {
        int size = 100; // размер списка
        Random random = new Random();
        DoublyLinkedList list = new DoublyLinkedList();
        for (int i = 0; i < size; i++) {
            list.add(random.nextInt());
        }
        Thread thread1 = new Thread(new Counter(list, 0)); // запуск первого потока
        Thread thread2 = new Thread(new Counter(list, 1)); // запуск второго потока
        thread1.start();
        thread2.start();
        try {
            thread1.join(); // ожидание завершения работы потоков
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Количество нулевых битов: " + Counter.zeroBitsCount);
        System.out.println("Количество единичных битов: " + Counter.oneBitsCount);
    }
}

class DoublyLinkedList {
    private Node head;
    private Node tail;
    private int size;

    public void add(int value) {
        Node node = new Node(value);
        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
        size++;
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public int getSize() {
        return size;
    }
}

class Node {
    int value;
    Node prev;
    Node next;

    public Node(int value) {
        this.value = value;
    }
}

class Counter implements Runnable {
    private DoublyLinkedList list;
    private int bit;
    public static int zeroBitsCount = 0;
    public static int oneBitsCount = 0;

    public Counter(DoublyLinkedList list, int bit) {
        this.list = list;
        this.bit = bit;
    }

    @Override
    public void run() {
        Node node;
        if (bit == 0) { // если считаем нулевые биты
            node = list.getHead();
            while (node != null) {
                synchronized (list) { // блокировка списка на время работы потока
                    if ((node.value & 1) == 0) { // проверка на нулевой бит
                        zeroBitsCount++;
                        node.prev.next = node.next; // удаление учтенного элемента
                        if (node.next != null) {
                            node.next.prev = node.prev;
                        } else {
                            list.getTail().prev = node.prev;
                        }
                    }
                    node = node.next;
                }
            }
        } else { // если считаем единичные биты
            node = list.getTail();
            while (node != null) {
                synchronized (list) {
                    if ((node.value & 1) == 1) { // проверка на единичный бит
                        oneBitsCount++;
                        node.next.prev = node.prev;
                        if (node.prev != null) {
                            node.prev.next = node.next;
                        } else {
                            list.getHead().next = node.next;
                        }
                    }
                    node = node.prev;
                }
            }
        }
    }
}