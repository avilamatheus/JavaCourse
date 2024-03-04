package entities;

public class Individual extends Taxpayer {
    Double healthCareExpenses;
    private static final double LOW_INCOME_VALUE = 20000.0;
    private static final double LOW_INCOME_TAX = 0.15;
    private static final double HIGH_INCOME_TAX = 0.25;
    private static final double HEALTH_CARE_DISCOUNT = 0.5;

    public Individual(String name, Double annualIncome, Double healthCareExpenses) {
        super(name, annualIncome);
        this.healthCareExpenses = healthCareExpenses;
    }

    public Double getHealthCareExpenses() {
        return healthCareExpenses;
    }

    public void setHealthCareExpenses(Double healthCareExpenses) {
        this.healthCareExpenses = healthCareExpenses;
    }

    @Override
    public Double taxDue() {
        double tax;

        if(annualIncome < LOW_INCOME_VALUE) {
            tax = annualIncome * (LOW_INCOME_TAX);
        } else {
            tax = annualIncome * (HIGH_INCOME_TAX);
        }

        tax = tax - (healthCareExpenses * HEALTH_CARE_DISCOUNT);

        return tax;
    }
}
