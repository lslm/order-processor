package validators;

import models.OrderToProcess;

public class ProductValidator implements IOrderValidator {

    @Override
    public void validate(OrderToProcess orderToProcess) {
        String productId = orderToProcess.getOrder().getProductId();

        if (productId.isBlank())
            orderToProcess.addViolation("Código do produto não informado");

        if (!productId.equals("1") && !productId.equals("2"))
            orderToProcess.addViolation("Código do produto inválido");
    }
}
