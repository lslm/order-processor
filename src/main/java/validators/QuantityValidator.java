package validators;

import models.OrderToProcess;

public class QuantityValidator implements IOrderValidator {

    @Override
    public void validate(OrderToProcess orderToProcess) {
        if (orderToProcess.getOrder().getQuantity() == 0)
            orderToProcess.addViolation("Quantidade inválida");
    }
}
