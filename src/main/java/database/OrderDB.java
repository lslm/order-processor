package database;

import java.util.HashMap;
import java.util.Map;

public class OrderDB {
    private static Map<String, Integer> availableQuantities = new HashMap<>();

    public static void setProductAvailableQuantity(String productId, int availableQuantity) {
        if (availableQuantities.get(productId) != null)
            throw new IllegalStateException("Initial quantity already set");

        availableQuantities.put(productId, availableQuantity);
    }

    public static int getProductAvailableQuantity(String productId) {
        return availableQuantities.get(productId);
    }

    public static void decreaseQuantityForProduct(String productId, int quantity) {
        availableQuantities.put(productId, availableQuantities.get(productId) - quantity);
    }
}
