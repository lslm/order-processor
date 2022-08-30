package adapters;

import models.Order;

public class OrderAdapter {
    public static Order getOrder(String orderLine) {
        String[] orderInfo = orderLine.split(",");
        return new Order(orderInfo[0], orderInfo[1], orderInfo[2], Integer.parseInt(orderInfo[3]));
    }
}
