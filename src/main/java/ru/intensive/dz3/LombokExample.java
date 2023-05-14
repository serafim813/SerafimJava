package ru.intensive.dz3;

import lombok.*;
import ru.intensive.dz2.dz02.Cat23;

import java.util.List;
import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class LombokExample {

    private String description;
    private int counter;
    private List<Cat23> cats;

    public static void main(String[] args) {
        LombokExample lombokExample01 = new LombokExample();
        lombokExample01.cats = List.of(new Cat23(), new Cat23());
        lombokExample01.counter = 2;
        lombokExample01.description = "Test01";

        LombokExample lombokExample02 = new LombokExample("Test02", 1, List.of());
        LombokExample lombokExample03 = new LombokExample("Test02", 1, List.of());

        System.out.println("Equal: " + lombokExample01.equals(lombokExample02)); //false
        System.out.println("Equal: " + Objects.equals(lombokExample02, lombokExample03)); //true
        System.out.println("Пример геттеров, определены только в Lombok");
        System.out.println(lombokExample01.getCats());
        System.out.println(lombokExample01.getCounter());
    }



    public static class WithoutLombok {

        private String description;
        private int counter;
        private List<Cat23> cats;

        public WithoutLombok() {
        }

        public WithoutLombok(String description, int counter, List<Cat23> cats) {
            this.description = description;
            this.counter = counter;
            this.cats = cats;
        }

        @Override
        public String toString() {
            return "WithoutLombok{" +
                    "description='" + description + '\'' +
                    ", counter=" + counter +
                    ", cats=" + cats +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            //this = withoutLombok02;
            if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
            WithoutLombok that = (WithoutLombok) o;
            return counter == that.counter && Objects.equals(description, that.description) && Objects.equals(cats, that.cats);
        }

        @Override
        public int hashCode() {
            return 1;
        }

        public static void main(String[] args) {
            WithoutLombok withoutLombok01 = new WithoutLombok();
            WithoutLombok withoutLombok04 = new WithoutLombok();

            WithoutLombok withoutLombok02 = new WithoutLombok("Test01", 1, List.of());
            WithoutLombok withoutLombok03 = new WithoutLombok("Test01", 1, List.of());

            System.out.println("Equal: " + withoutLombok02.equals(withoutLombok03)); //true
        }
    }
}