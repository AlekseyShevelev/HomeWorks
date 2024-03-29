﻿import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class OrderSaver {
    private final Order order;

    public OrderSaver(Order order) {
        this.order = order;
    }

    public void saveToJson(String fileName) {
        try (FileWriter writer = new FileWriter(fileName, StandardCharsets.UTF_8, false)) {
            writer.write("{\n");
            writer.write("\"clientName\":\"" + order.getClientName() + "\",\n");
            writer.write("\"product\":\"" + order.getProduct() + "\",\n");
            writer.write("\"qnt\":" + order.getQnt() + ",\n");
            writer.write("\"price\":" + order.getPrice() + "\n");
            writer.write("}\n");
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
