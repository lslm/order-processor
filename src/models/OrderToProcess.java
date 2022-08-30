package models;

import java.util.ArrayList;
import java.util.List;

public class OrderToProcess {
    private final Order order;
    private List<String> violations;

    public OrderToProcess(Order order) {
        this.order = order;
        violations = new ArrayList<>();
    }

    public Order getOrder() {
        return order;
    }

    public List<String> getViolations() {
        return violations;
    }

    public void addViolation(String violation) {
        violations.add(violation);
    }

    public boolean hasViolations() {
        return violations.size() > 0;
    }
}
