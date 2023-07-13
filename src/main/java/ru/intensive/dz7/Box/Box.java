package ru.intensive.dz7.Box;

import java.util.ArrayList;

public class Box<T extends Fruit> {
    private ArrayList<T> fruits = new ArrayList<>();

    public void addFruit(T fruit) {
        fruits.add(fruit);
    }

    public float getWeight() {
        if (fruits.size() == 0) {
            return 0.0f;
        }
        float weight = fruits.size() * fruits.get(0).getWeight();
        return weight;
    }

    public boolean compare(Box<?> box) {
        return Math.abs(this.getWeight() - box.getWeight()) < 0.0001;
    }

    public void transferTo(Box<T> box) {
        if (this == box) {
            return;
        }
        for (T fruit : fruits) {
            box.addFruit(fruit);
        }
        fruits.clear();
    }

    public static void main(String[] args) {
        Box<Apple> appleBox1 = new Box<>();
        appleBox1.addFruit(new Apple());
        appleBox1.addFruit(new Apple());
        appleBox1.addFruit(new Apple());

        Box<Apple> appleBox2 = new Box<>();
        appleBox2.addFruit(new Apple());
        appleBox2.addFruit(new Apple());

        Box<Orange> orangeBox = new Box<>();
        orangeBox.addFruit(new Orange());
        orangeBox.addFruit(new Orange());
        orangeBox.addFruit(new Orange());

        System.out.println("Weight of appleBox1: " + appleBox1.getWeight()); // Weight of appleBox1: 3.0
        System.out.println("Weight of appleBox2: " + appleBox2.getWeight()); // Weight of appleBox2: 2.0
        System.out.println("Weight of orangeBox: " + orangeBox.getWeight()); // Weight of orangeBox: 4.5

        System.out.println("appleBox1 compare to appleBox2: " + appleBox1.compare(appleBox2)); // appleBox1 compare to appleBox2: false
        System.out.println("appleBox1 compare to orangeBox: " + appleBox1.compare(orangeBox)); // appleBox1 compare to orangeBox: false

        appleBox1.transferTo(appleBox2);
        System.out.println("Weight of appleBox1 after transfer: " + appleBox1.getWeight()); // Weight of appleBox1 after transfer: 0.0
        System.out.println("Weight of appleBox2 after transfer: " + appleBox2.getWeight()); // Weight of appleBox2 after transfer: 5.0
    }
}
