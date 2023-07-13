package ru.intensive.dz4;

//
//class Printable {
//    public void print(String str) {
//        System.out.println(str);
//    }
//    public static void main(String[] args) {
//        Printable printable = new Printable(){
//            @Override
//            public void print(String str) {
//                System.out.println("Готовим " + str);
//            }
//        };
//        printable.print("торт");
//    }
//}
interface Printable {
    void print();
}

public class AnonymousPrintable {
    public static void main(String[] args) {
        Printable p = new Printable() {
            public void print() {
                System.out.println("Hello, world!");
            }
        };
        p.print();
    }
}


