package entities;

public class CurrencyConverter {

    private final static double TAX_PERCENTAGE = 6.00;
    public static void reaisToDollar(double dolarPrice, double dollarQuantity) {
        double amount = dollarQuantity*dolarPrice;
        double tax = amount*(TAX_PERCENTAGE/100);
        amount = amount + tax;
        System.out.printf("Amount to be paid in Reais: R$%.2f%n", amount);
    }

}
