package application;

import entities.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        List<Employee> employeeList = new ArrayList<>();

        employeeList.add(new Employee(333, "Maria Brown", 4000.00));
        employeeList.add(new Employee(536, "Alex Grey", 3000.00));
        employeeList.add(new Employee(772, "Bob Green", 5000.00));
        int id = 536;
        double percentage = 50.00;

        employeeTest(id, percentage, employeeList);

        // non-existing id
        employeeTest(1000, percentage, employeeList);
    }

    public static void employeeTest(int id, double percentage, List<Employee> employeeList) {
        Employee employeeOptional = employeeList.stream().filter(x -> x.getId() == id).findFirst().orElse(null);

        if(employeeOptional != null) {
            employeeOptional.increaseSalary(percentage);
        } else {
            System.out.printf("This id (%d) does not exist!\n", id);
        }
        System.out.println("List of employees:");
        for (Employee employee: employeeList) {
            System.out.println(employee);
        }
        System.out.println();
    }
}