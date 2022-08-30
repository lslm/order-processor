import adapters.OrderAdapter;
import controllers.OrderProcessor;
import database.OrderDB;
import input.OrdersReader;
import models.Order;

import java.io.IOException;
import java.util.Scanner;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Qual a quantidade do produto 1: ");
        int product1Quantity = scanner.nextInt();

        System.out.print("Qual a quantidade do produto 2: ");
        int product2Quantity = scanner.nextInt();

        OrderDB.setProductAvailableQuantity("1", product1Quantity);
        OrderDB.setProductAvailableQuantity("2", product2Quantity);

        OrdersReader ordersReader = new OrdersReader();
        OrderProcessor orderProcessor = new OrderProcessor();

        Stream<String> orders = ordersReader.getOrders();

        orders.skip(1).forEach((orderLine) -> {
            Order order = OrderAdapter.getOrder(orderLine);
            orderProcessor.process(order);
        });
    }
}
