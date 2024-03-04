package entities;

public class ImportedProduct extends Product {
    protected Double customFee;

    public ImportedProduct(String name, Double price, Double customFee) {
        super(name, price);
        this.customFee = customFee;
    }

    public Double getCustomFee() {
        return customFee;
    }

    public void setCustomFee(Double customFee) {
        this.customFee = customFee;
    }

    @Override
    public String priceTag() {
        return this.name + " $" + this.totalPrice() + " (Customs fee: $" + this.customFee + ")";
    }

    private Double totalPrice() {
        return this.price + this.customFee;
    }
}
