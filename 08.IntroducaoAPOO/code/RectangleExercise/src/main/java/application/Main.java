package application;

import entities.Rectangle;

import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        // Configurando a formatação para usar o ponto como separador decimal
        Locale.setDefault(Locale.US);

        Rectangle rectangle = new Rectangle(3, 4);
        System.out.printf("Rectangle Area: %.2f%n", rectangle.getArea());
        System.out.printf("Rectangle Perimeter: %.2f%n", rectangle.getPerimeter());
        System.out.printf("Rectangle Diagonal: %.2f%n", rectangle.getDiagonal());
    }
}