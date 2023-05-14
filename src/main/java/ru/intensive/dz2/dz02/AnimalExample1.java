package ru.intensive.dz2.dz02;

public class AnimalExample1 {
    public static void main(String[] args) {
        Cat23 cat = new Cat23();
        //Cat cat = new Cat();
        Dog dog = new Dog();
        //Dog21 dog = new Dog21();

        System.out.println(cat);
        System.out.println(dog);

        System.out.println(System.lineSeparator());
        System.out.println(cat.run(250));
        System.out.println(cat.swim(20));
        System.out.println(cat.leap(2));

        System.out.println(System.lineSeparator());
        System.out.println(dog.run(400));
        System.out.println(dog.swim(25));
        System.out.println(dog.leap(3));

        Cat cat1 = new Cat();
        System.out.println(cat.run(400));
        System.out.println(cat.swim(25));
    }
}