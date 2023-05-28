package ru.intensive.dz4;

abstract class AnonymousCookable {
    public abstract void cook(String str);
}

class Food {
    public void prepare(AnonymousCookable c, String str) {
        c.cook(str);
    }
    public static void main(String[] args) {
        Food food = new Food();

        // передаем анонимный класс, который расширяет Cookable и переопределяет метод cook
        food.prepare(new AnonymousCookable() {
            @Override
            public void cook(String str) {
                System.out.println("Готовим " + str);
            }
        }, "торт");
    }
}
