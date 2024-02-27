package entities.enums;

/**
 * Enumeração que representa o status de um pedido.
 */
public enum OrderStatus {
    PENDING_PAYMENT("Pagamento Pendente"),
    PROCESSING("Pedido em processamento"),
    SHIPPED("Pedido enviado para a transportadora"),
    DELIVERED("Pedido entregue");

    private final String value;

    /**
     * Construtor que recebe um valor para a enumeração.
     */
    OrderStatus(String value) {
        this.value = value;
    }

    /**
     * Método que retorna o valor associado a enumeração.
     */
    public String getValue() {
        return value;
    }
}
