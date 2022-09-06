package controllers;

import database.OrderDB;
import models.Order;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderProcessorTest {
    @BeforeAll
    static void setup() {
        OrderDB.setProductAvailableQuantity("1", 10);
    }

    @Test
    void validateWhenThereIsNoViolation() {
        OrderProcessor orderProcessor = new OrderProcessor();
        Order order = new Order("lucas", "lucas@gmail.com", "1", 6);

        orderProcessor.process(order);

        assertEquals(4,OrderDB.getProductAvailableQuantity("1"));
    }

    @Test
    void validateWhenThereIsAViolation() {
        OrderProcessor orderProcessor = new OrderProcessor();
        Order order = new Order("", "lucas@gmail.com", "1", 6);

        orderProcessor.process(order);

        assertEquals(10,OrderDB.getProductAvailableQuantity("1"));
    }
}
