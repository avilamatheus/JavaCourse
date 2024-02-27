package application;

import entities.CurrencyConverter;

import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        CurrencyConverter.reaisToDollar(3.10, 200);
    }
}