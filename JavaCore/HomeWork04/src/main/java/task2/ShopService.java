package task2;

import task2.exceptions.CustomerNotExists;
import task2.exceptions.ProductNotExists;
import task2.exceptions.WrongQuantity;

import java.util.ArrayList;
import java.util.List;

public class ShopService {
    private static List<Customer> customers = new ArrayList<>();
    private static List<Product> products = new ArrayList<>();
    private static List<Order> orders = new ArrayList<>();

    public static List<Customer> getCustomers() {
        return customers;
    }

    public static List<Product> getProducts() {
        return products;
    }

    public static List<Order> getOrders() {
        return orders;
    }

    static Order makeOrder(String customer, String product, int quantity) throws CustomerNotExists, ProductNotExists, WrongQuantity {
        Customer curCustomer = null;

        for (Customer c: customers) {
            if (c.getFio().equals(customer)) {
                curCustomer = c;
                break;
            }
        }

        if (curCustomer ==  null) {
            throw new CustomerNotExists("Покупатель не найден.");
        }

        Product curProduct = null;

        for (Product p: products) {
            if (p.getName().equals(product)) {
                curProduct = p;
                break;
            }
        }

        if (curProduct ==  null) {
            throw new ProductNotExists("Товар не найден.");
        }

        if (quantity <= 0 || quantity > 100) {
            throw new WrongQuantity("Неверное количество товара.", customer, product);
        }

        return new Order(curCustomer, curProduct, quantity);
    }
}
