package validators;

import models.Order;
import models.OrderToProcess;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EmailValidatorTest {
    @Test
    void validateWhenEmailIsEmpty() {
        EmailValidator emailValidator = new EmailValidator();
        Order order = new Order("lucas", "", "01", 10);
        OrderToProcess orderToProcess = new OrderToProcess(order);

        emailValidator.validate(orderToProcess);

        Assertions.assertTrue(orderToProcess.hasViolations());
    }

    @Test
    void validateWhenEmailIsNull() {
        EmailValidator emailValidator = new EmailValidator();
        Order order = new Order("lucas", null, "01", 10);
        OrderToProcess orderToProcess = new OrderToProcess(order);

        emailValidator.validate(orderToProcess);

        Assertions.assertTrue(orderToProcess.hasViolations());
    }

    @Test
    void validateWhenEmailIsPresent() {
        EmailValidator emailValidator = new EmailValidator();
        Order order = new Order("lucas", "lucas@gmail.com", "01", 10);
        OrderToProcess orderToProcess = new OrderToProcess(order);

        emailValidator.validate(orderToProcess);

        Assertions.assertFalse(orderToProcess.hasViolations());
    }
}
