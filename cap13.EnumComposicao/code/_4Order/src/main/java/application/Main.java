package application;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        DateTimeFormatter dateTimeBr = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        Client client = new Client("Alex Green",
                "alex@gmail.com",
                LocalDate.parse("15/03/1985", dateTimeBr));

        Order order = new Order(client);
        Product productTv = new Product("TV", 1000.00);
        Product productMouse = new Product("Mouse", 40.00);

        order.addItem(new OrderItem(5, productTv.getPrice(), productTv));
        order.addItem(new OrderItem(10, productMouse.getPrice(), productMouse));

        System.out.println(order.summary());
    }
}