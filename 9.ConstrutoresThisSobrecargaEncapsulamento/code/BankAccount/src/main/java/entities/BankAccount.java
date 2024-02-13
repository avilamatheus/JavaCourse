package entities;

public class BankAccount {
    private final int accountNumber;
    private String accountHolderName;
    private double balance;
    private static final double WITHDRAW_TAX = 5.00;

    public BankAccount(int accountNumber, String accountHolderName, double initialAmount) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        deposit(initialAmount);
    }

    public BankAccount(int accountNumber, String accountHolderName) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = 0;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance = balance + amount;
    }

    public void withdraw(double amount) {
        balance = balance - amount - WITHDRAW_TAX;
    }

    @Override
    public String toString() {
        return "Account data:\n"
                + "Account: "
                + accountNumber
                + ", Holder: "
                + accountHolderName
                + ", Balance: $"
                + String.format("%.2f", balance)
                + "\n";
    }
}
