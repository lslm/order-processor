package validators;

import database.OrderDB;
import models.OrderToProcess;

public class AvailableQuantityValidator implements IOrderValidator {

    @Override
    public void validate(OrderToProcess orderToProcess) {
        int availableQuantity = orderToProcess.getOrder().getQuantity();
        String productId = orderToProcess.getOrder().getProductId();

        if (!productId.isBlank() && availableQuantity > OrderDB.getProductAvailableQuantity(productId))
            orderToProcess.addViolation("Quantidade indisponível");
    }
}
