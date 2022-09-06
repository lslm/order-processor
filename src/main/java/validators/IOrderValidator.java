package validators;

import models.OrderToProcess;

public interface IOrderValidator {
    void validate(OrderToProcess orderToProcess);
}
