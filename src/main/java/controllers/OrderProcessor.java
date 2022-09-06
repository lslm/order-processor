package controllers;

import database.OrderDB;
import models.Order;
import models.OrderToProcess;
import validators.*;

import java.util.List;

public class OrderProcessor {
    private final List<IOrderValidator> validators =
            List.of(new EmailValidator(),
                    new ProductValidator(),
                    new NameValidator(),
                    new QuantityValidator(),
                    new AvailableQuantityValidator());

    public void process(Order order) {
        OrderToProcess orderToProcess = new OrderToProcess(order);
        validators.forEach((validator) -> validator.validate(orderToProcess));

        if (orderToProcess.hasViolations()) {
            orderToProcess.getViolations().forEach(System.out::println);
            return;
        }

        OrderDB.decreaseQuantityForProduct(order.getProductId(), order.getQuantity());
        System.out.println("Pedido recebido: " + order);
    }
}
