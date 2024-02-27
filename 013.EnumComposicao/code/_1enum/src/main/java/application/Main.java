package application;

import entities.Order;
import entities.enums.OrderStatus;

import java.time.Instant;

public class Main {
    public static void main(String[] args) {
        /**
         * Instanciando objetos da classe Order, que representa um pedido, usando valores de exemplo.
         */
        Order order1 = new Order(1,
                Instant.now(),
                OrderStatus.PENDING_PAYMENT);
        Order order2 = new Order(2,
                Instant.parse("2024-02-27T12:30:00-03:00"),
                OrderStatus.PROCESSING);
        Order order3 = new Order(3,
                Instant.parse("2024-02-27T08:30:00-03:00"),
                OrderStatus.SHIPPED);
        Order order4 = new Order(4,
                Instant.parse("2024-02-25T08:30:00-03:00"),
                OrderStatus.DELIVERED);

        /**
         * Imprimindo os objetos instanciados.
         */
        System.out.println(order1);
        System.out.println(order2);
        System.out.println(order3);
        System.out.println(order4);

        /**
         * Testando a conversão de uma String para um valor do tipo OrderStatus 
         * e também a obtenção do valor associado a um valor do tipo OrderStatus.
         */
        OrderStatus os1 = OrderStatus.DELIVERED;
        OrderStatus os2 = OrderStatus.valueOf("SHIPPED");

        /**
         * Imprimindo os valores associados aos objetos os1 e os2.
         */
        System.out.println(os1.getValue());
        System.out.println(os2.getValue());
    }
}