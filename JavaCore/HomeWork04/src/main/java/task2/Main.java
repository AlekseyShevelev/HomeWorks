package task2;

import task2.exceptions.CustomerNotExists;
import task2.exceptions.ProductNotExists;
import task2.exceptions.WrongQuantity;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws CustomerNotExists, ProductNotExists, WrongQuantity {
        ShopService.getCustomers().add(new Customer(
                "Иванов С.П.",
                LocalDate.of(1980, 12, 9),
                Customer.Gender.MALE,
                "+7(921)123-45-67"));
        ShopService.getCustomers().add(new Customer(
                "Петрова А.В.",
                LocalDate.of(1985, 7, 20),
                Customer.Gender.FEMALE,
                "+7(931)987-65-43"));

        ShopService.getProducts().add(new Product("Apple", 120.0d));
        ShopService.getProducts().add(new Product("Bread", 40.0d));

        Order order;

        try {
            order = ShopService.makeOrder("Иванов С.П.", "Apple", 2);
            ShopService.getOrders().add(order);
            System.out.println(order);

            order = ShopService.makeOrder("Петрова А.В.", "Bread", 1);
            ShopService.getOrders().add(order);
            System.out.println(order);

            order = ShopService.makeOrder("Петрова А.В.", "Apple", -1);
            System.out.println(order);
        }
        catch (WrongQuantity e) {
            System.out.println(e.getMessage());
            order = ShopService.makeOrder(e.getCustomer(), e.getProduct(), 1);
            ShopService.getOrders().add(order);
            System.out.println(order);
        }
        catch (CustomerNotExists e) {
            throw e;
        }
        catch (ProductNotExists e) {
            System.out.println(e.getMessage());
        }

        System.out.printf("Всего заказов: %s\n", ShopService.getOrders().size());
        System.out.println();

        CongratulationsService.sendGreetings(ShopService.getCustomers(), LocalDate.of(2024, 1, 1));
        System.out.println();
        CongratulationsService.sendGreetings(ShopService.getCustomers(), LocalDate.of(2024, 2, 23));
        System.out.println();
        CongratulationsService.sendGreetings(ShopService.getCustomers(), LocalDate.of(2024, 3, 8));
    }
}
