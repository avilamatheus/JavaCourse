package application;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;
import utils.DateTimeBrazilPattern;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Product> productList = new ArrayList<>();

        productList.add(new ImportedProduct("Tablet", 260.00, 20.00));
        productList.add(new Product("Notebook", 1100.0));
        productList.add(new UsedProduct("iPhone", 400.00, DateTimeBrazilPattern.parseLocalDate("15/03/2017")));

        for (Product prod: productList) {
            System.out.println(prod.priceTag());
        }

    }
}