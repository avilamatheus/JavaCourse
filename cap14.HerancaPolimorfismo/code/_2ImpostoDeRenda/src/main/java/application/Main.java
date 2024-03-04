package application;

import entities.Company;
import entities.Individual;
import entities.Taxpayer;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Taxpayer> taxpayerList = new ArrayList<>();

        taxpayerList.add(new Individual("Alex", 50000.0, 2000.00));
        taxpayerList.add(new Company("SoftTech", 400000.00, 25));
        taxpayerList.add(new Individual("Bob", 120000.0, 1000.00));

        double totalTax = 0;
        System.out.println("TAXES PAID:");
        for (Taxpayer taxpayer: taxpayerList) {
            double tax = taxpayer.taxDue();
            System.out.println(taxpayer.getName() + ": $" + String.format("%.2f", tax));
            totalTax = totalTax + tax;
        }
        System.out.println("\nTOTAL TAXES: $" + String.format("%.2f", totalTax));
    }
}