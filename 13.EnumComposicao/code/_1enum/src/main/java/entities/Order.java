package entities;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import entities.enums.OrderStatus;

/**
 * Classe que representa um pedido.
 */
public class Order {

    /**
     * Identificador do pedido.
     */
    private Integer id;

    /**
     * Data do pedido.
     */
    private Instant orderDate;

    /**
     * Status do pedido.
     * @see OrderStatus
     */
    private OrderStatus status;

    /**
     * Construtor responsável por instanciar um pedido.
     * @param id Identificador do pedido.
     * @param orderDate Data do pedido.
     * @param status Status do pedido.
     */
    public Order(Integer id, Instant orderDate, OrderStatus status) {
        this.id = id;
        this.orderDate = orderDate.truncatedTo(ChronoUnit.MINUTES);
        this.status = status;
    }

    /**
     * Método toString que retorna uma representação textual do pedido.
     */
    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", moment=" + orderDate +
                ", status=" + status.getValue() +
                '}';
    }
}
