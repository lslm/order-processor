package validators;

import models.OrderToProcess;

public class NameValidator implements IOrderValidator {
    @Override
    public void validate(OrderToProcess orderToProcess) {
        if (orderToProcess.getOrder().getName().isBlank())
            orderToProcess.addViolation("Nome não informado");
    }
}
