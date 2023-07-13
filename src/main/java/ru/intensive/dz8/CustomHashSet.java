package ru.intensive.dz8;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CustomHashSet<E> extends HashSet<E> {
    public CustomHashSet() {
        super();
    }

    public CustomHashSet(Set<E> set) {
        super(set);
    }

    public Set<E> union(Set<E> set) {
        CustomHashSet<E> unionSet = new CustomHashSet<>(this);
        unionSet.addAll(set);
        return unionSet;
    }

    public Set<E> intersect(Set<E> set) {
        this.retainAll(set);
        return this;
    }

    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(4, 5, 6, 7, 8));
        CustomHashSet<Integer> customSet = new CustomHashSet<>(set1);
        Set<Integer> unionSet = customSet.union(set2);
        Set<Integer> intersectSet = customSet.intersect(set2);
        System.out.println("Union set: " + unionSet);
        System.out.println("Intersection set: " + intersectSet);
    }
}