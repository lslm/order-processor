package models;

public class Order {
    private final String name;
    private final String email;
    private final String productId;
    private final int quantity;

    public Order(String name, String email, String productId, int quantity) {
        this.name = name;
        this.email = email;
        this.productId = productId;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getProductId() {
        return productId;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "Order{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", productId='" + productId + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
