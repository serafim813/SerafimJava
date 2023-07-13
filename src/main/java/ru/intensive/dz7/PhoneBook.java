package ru.intensive.dz7;

import java.util.*;

public class PhoneBook {
    private Map<String, Set<String>> phoneBook;

    public PhoneBook() {
        phoneBook = new HashMap<>();
    }

    public void add(String surname, String phoneNumber) {
        if (phoneBook.containsKey(surname)) {
            phoneBook.get(surname).add(phoneNumber);
        } else {
            Set<String> phoneNumbers = new HashSet<>();
            phoneNumbers.add(phoneNumber);
            phoneBook.put(surname, phoneNumbers);
        }
    }

    public Set<String> get(String surname) {
        return phoneBook.get(surname);
    }

    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();

        phoneBook.add("Ivanov", "123-45-67");
        phoneBook.add("Petrov", "234-56-78");
        phoneBook.add("Sidorov", "345-67-89");
        phoneBook.add("Ivanov", "456-78-90");

        System.out.println("Телефонный справочник:");
        System.out.println("Ivanov: " + phoneBook.get("Ivanov"));
        System.out.println("Petrov: " + phoneBook.get("Petrov"));
        System.out.println("Sidorov: " + phoneBook.get("Sidorov"));
    }
}
