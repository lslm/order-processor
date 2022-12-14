package input;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class OrdersReader {
    private final String filepath = "/Users/lucassantos/Downloads/pedidos.csv";

    public Stream<String> getOrders() throws IOException {
        Path path = Paths.get(filepath);
        return Files.lines(path);
    }
}
