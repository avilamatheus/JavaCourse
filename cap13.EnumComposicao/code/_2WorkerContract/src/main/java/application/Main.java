package application;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        Worker worker1 = new Worker("Alex",
                WorkerLevel.MID_LEVEL,
                1200.00, new Department("Design"));

        worker1.addContract(new HourContract(50.00, 20, "20/08/2018"));
        worker1.addContract(new HourContract(30.00, 18, "13/06/2018"));
        worker1.addContract(new HourContract(80.00, 10, "25/08/2018"));

        String dateIncome = "08/2018";
        YearMonth date = YearMonth.parse(dateIncome, DateTimeFormatter.ofPattern("MM/yyyy"));

        double income = worker1.income(date.getYear(), date.getMonthValue());

        System.out.println("Name: " + worker1.getName());
        System.out.println("Department: " + worker1.getDepartment().getName());
        System.out.println("Income for " + dateIncome + ": " + income);
    }
}