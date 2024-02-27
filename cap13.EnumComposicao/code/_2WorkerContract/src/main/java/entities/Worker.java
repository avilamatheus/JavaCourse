package entities;

import entities.enums.WorkerLevel;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Worker {
    private String name;
    private WorkerLevel level;
    private double baseSalary;
    private Department department;
    private List<HourContract> contracts = new ArrayList<>();

    public Worker(String name, WorkerLevel level, double baseSalary, Department department) {
        this.name = name;
        this.level = level;
        this.baseSalary = baseSalary;
        this.department = department;
    }

    public void addContract(HourContract contract) {
        contracts.add(contract);
    }

    public void removeContract(HourContract contract) {
        contracts.remove(contract);
    }

    public double income(int year, int month) {
        double sum = baseSalary;
        for (HourContract hourContract: contracts) {
            LocalDate contractDate = hourContract.getDate();
            if(contractDate.getYear() == year && contractDate.getMonthValue() == month) {
                sum = sum + hourContract.totalValue();
            }
        }
        return sum;
    }

    public String getName() {
        return name;
    }

    public Department getDepartment() {
        return department;
    }
}
