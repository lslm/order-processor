package validators;

import database.OrderDB;
import models.Order;
import models.OrderToProcess;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class AvailableQuantityValidatorTest {
    @BeforeAll
    public static void setup() {
        OrderDB.setProductAvailableQuantity("01", 10);
    }

    @Test
    void validateWhenThereIsNotSufficientProductInStock() {
        AvailableQuantityValidator availableQuantityValidator = new AvailableQuantityValidator();
        Order order = new Order("lucas", "lucas@gmail.com", "01", 11);
        OrderToProcess orderToProcess = new OrderToProcess(order);

        availableQuantityValidator.validate(orderToProcess);

        assertTrue(orderToProcess.hasViolations());
    }

    @Test
    void validateWhenQuantityIsTheSameAsInStock() {
        AvailableQuantityValidator availableQuantityValidator = new AvailableQuantityValidator();
        Order order = new Order("lucas", "lucas@gmail.com", "01", 10);
        OrderToProcess orderToProcess = new OrderToProcess(order);

        availableQuantityValidator.validate(orderToProcess);

        assertFalse(orderToProcess.hasViolations());
    }

    @Test
    void validateWhenQuantityIsLessThanInStock() {
        AvailableQuantityValidator availableQuantityValidator = new AvailableQuantityValidator();
        Order order = new Order("lucas", "lucas@gmail.com", "01", 9);
        OrderToProcess orderToProcess = new OrderToProcess(order);

        availableQuantityValidator.validate(orderToProcess);

        assertFalse(orderToProcess.hasViolations());
    }
}
