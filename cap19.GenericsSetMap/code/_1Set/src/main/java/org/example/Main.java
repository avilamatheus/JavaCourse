package org.example;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<Integer> courseA = new HashSet<>();
        Set<Integer> courseB = new HashSet<>();
        Set<Integer> courseC = new HashSet<>();

        courseA.add(21);
        courseA.add(35);
        courseA.add(22);

        courseB.add(21);
        courseB.add(50);

        courseC.add(42);
        courseC.add(35);
        courseC.add(13);

        Set<Integer> total = new HashSet<>(courseA);
        total.addAll(courseB);
        total.addAll(courseC);

        System.out.println("Total num of students: " + total.size());
    }
}