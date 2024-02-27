package application;

import entities.Student;

import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        Student student1 = new Student("Marcos Paulo", 17.00, 20.00, 15.00);
        student1.isApproved();

        Student student2 = new Student("Matheus Avila", 27.00, 31.00, 32.00);
        student2.isApproved();
    }
}