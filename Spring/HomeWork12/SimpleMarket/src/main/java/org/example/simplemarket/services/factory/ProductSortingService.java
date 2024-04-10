package org.example.simplemarket.services.factory;

import org.example.simplemarket.model.Product;

import java.util.List;

public interface ProductSortingService {
    List<Product> sort(List<Product> products);
}
