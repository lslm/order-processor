package adapters;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderAdapterTest {
    @Test
    void validateOrderLineForName() {
        String orderLine = "Lucas,lucas@gmail,1,4";
        assertEquals("Lucas", OrderAdapter.getOrder(orderLine).getName());
    }

    @Test
    void validateOrderLineForEmail() {
        String orderLine = "Lucas,lucas@gmail,1,4";
        assertEquals("lucas@gmail", OrderAdapter.getOrder(orderLine).getEmail());
    }

    @Test
    void validateOrderLineForProductId() {
        String orderLine = "Lucas,lucas@gmail,1,4";
        assertEquals("1", OrderAdapter.getOrder(orderLine).getProductId());
    }
}
