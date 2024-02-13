package entities;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String name;
    private List<Double> grades = new ArrayList<>(3);
    private double finalGrade = 0;

    public Student(String name, Double p1, Double p2, Double p3) {
        this.name = name;
        grades.add(p1);
        grades.add(p2);
        grades.add(p3);
        this.finalGrade = calculateFinalGrade();
    }

    private double calculateFinalGrade() {
        double finalGrade = 0;
        for (Double grade: grades) {
            finalGrade = finalGrade + grade;
        }
        return finalGrade;
    }

    public void isApproved() {
        System.out.println("Name: " + name);
        System.out.println("Final grade: " + finalGrade);
        System.out.print("Result: ");
        if (finalGrade < 60) {
            System.out.println("FAILED");
            System.out.printf("MISSING %.2f POINTS", (60-finalGrade));
        } else {
            System.out.println("PASS");
        }
        System.out.println("\n");
    }




}
