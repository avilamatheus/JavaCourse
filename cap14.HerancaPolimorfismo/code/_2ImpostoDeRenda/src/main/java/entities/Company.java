package entities;

public class Company extends Taxpayer {
    Integer numberOfEmployees;

    private static final int BIG_NUMBER_OF_EMPLOYEES = 10;
    private static final double BIG_NUMBER_OF_EMPLOYEES_TAX = 0.14;
    private static final double SMALL_NUMBER_OF_EMPLOYEES_TAX = 0.16;


    public Company(String name, Double annualIncome, Integer numberOfEmployees) {
        super(name, annualIncome);
        this.numberOfEmployees = numberOfEmployees;
    }

    @Override
    public Double taxDue() {
        double tax;

        if (numberOfEmployees > BIG_NUMBER_OF_EMPLOYEES) {
            tax = annualIncome * BIG_NUMBER_OF_EMPLOYEES_TAX;
        } else {
            tax = annualIncome * SMALL_NUMBER_OF_EMPLOYEES_TAX;
        }

        return tax;
    }
}
