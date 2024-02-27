package entities;

import entities.enums.OrderStatus;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private LocalDateTime orderMoment;
    private OrderStatus orderStatus;
    private Client client;
    private List<OrderItem> orderItems = new ArrayList<>();

    public Order(Client client) {
        this.orderMoment = LocalDateTime.now();
        this.orderStatus = OrderStatus.PENDING_PAYMENT;
        this.client = client;
    }

    public LocalDateTime getOrderMoment() {
        return orderMoment;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Client getClient() {
        return client;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void addItem(OrderItem orderItem) {
        orderItems.add(orderItem);
    }

    public void removeItem(OrderItem orderItem) {
        orderItems.remove(orderItem);
    }

    public String summary() {
        String output = "Order Moment: " + formatMoment() + "\n"
                + "Order Status: " + orderStatus + "\n"
                + "Client: " + client.getName() + " (" +
                client.getBirthDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
                + ") - " + client.getEmail() + "\n" + "Order items:" + "\n";

        double totalPrice = 0;
        for (OrderItem orderItem: orderItems) {
            double orderItemSubtotal = orderItem.subTotal();
            totalPrice = totalPrice + orderItemSubtotal;
            output = output + orderItem.getProduct().getName() + ", $" +
                    orderItem.getPrice() + ", Quantity: " + orderItem.getQuantity() +
                    ", Subtotal: $" + orderItemSubtotal + "\n";
        }
        output = output + "Total price: $" + totalPrice;
        return output;
    }

    private String formatMoment() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return dateTimeFormatter.format(this.orderMoment);
    }

}
