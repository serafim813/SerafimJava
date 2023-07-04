package ru.intensive.dz8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

public class PersonCollectionExample {
    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("John", 25));
        personList.add(new Person("Alice", 30));
        personList.add(new Person("Bob", 20));
        personList.add(new Person("David", 35));

        // Сортировка по имени
        Comparator<Person> nameComparator = Comparator.comparing(Person::getName);
        personList.sort(nameComparator);

        System.out.println("Сортировка по имени:");
        personList.forEach(person -> System.out.println(person .getName() + ", " + person.getAge()));

        // Сортировка по возрасту
        Comparator<Person> ageComparator = Comparator.comparingInt(Person::getAge);
        personList.sort(ageComparator);

        System.out.println("\nСортировка по возрасту:");
        personList.forEach(person -> System.out.println(person.getName() + ", " + person.getAge()));
    }
}
