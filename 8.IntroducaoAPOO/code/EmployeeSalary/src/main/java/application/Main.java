package application;

import entities.Employee;

import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        // Configurando a formatação para usar o ponto como separador decimal
        Locale.setDefault(Locale.US);

        Employee employee = new Employee("João Silva", 6000, 1000);

        System.out.println(employee);

        employee.increaseSalary(10);

        System.out.println(employee);
    }
}