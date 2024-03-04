package entities;

import utils.DateTimeBrazilPattern;

import java.time.LocalDate;

public class UsedProduct extends Product{
    protected LocalDate manufactureDate;

    public UsedProduct(String name, Double price, LocalDate manufactureDate) {
        super(name, price);
        this.manufactureDate = manufactureDate;
    }

    public LocalDate getManufactureDate() {
        return manufactureDate;
    }

    public void setManufactureDate(LocalDate manufactureDate) {
        this.manufactureDate = manufactureDate;
    }

    @Override
    public String priceTag() {
        return this.name + " (Used) $" + this.price + " (Manufacture date: " +
                DateTimeBrazilPattern.formatLocalDate(manufactureDate) + ")";
    }
}
