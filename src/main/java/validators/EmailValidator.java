package validators;

import models.OrderToProcess;

public class EmailValidator implements IOrderValidator {
    @Override
    public void validate(OrderToProcess orderToProcess) {
        if (orderToProcess.getOrder().getEmail().isBlank())
            orderToProcess.addViolation("Email não informado");
    }
}
