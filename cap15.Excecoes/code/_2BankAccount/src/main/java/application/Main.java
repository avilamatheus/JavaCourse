package application;

import model.entities.Account;
import model.exceptions.AccountException;

public class Main {
    public static void main(String[] args) {
        try {
            Account account = new Account(8021,
                    "Bob Brown",
                    100.00,
                    300.00);

            account.withdraw(500.00);
            System.out.println("New balance: " + account.getBalance());

        } catch (AccountException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}