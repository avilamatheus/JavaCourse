package application;

import entities.BankAccount;

import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        BankAccount bankAccount1 = new BankAccount(8532,
                "Alex Green", 500.00);
        System.out.println(bankAccount1);

        bankAccount1.deposit(200);
        System.out.println(bankAccount1);

        bankAccount1.withdraw(300);
        System.out.println(bankAccount1);

        BankAccount bankAccount2 = new BankAccount(7801,
                "Maria Brown");

        System.out.println(bankAccount2);

        bankAccount2.deposit(200);
        System.out.println(bankAccount2);

        bankAccount2.withdraw(198);
        System.out.println(bankAccount2);
    }
}