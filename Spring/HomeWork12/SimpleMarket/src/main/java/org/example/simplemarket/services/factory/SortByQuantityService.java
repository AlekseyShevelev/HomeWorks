package org.example.simplemarket.services.factory;

import org.example.simplemarket.model.Product;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service("quantity")
public class SortByQuantityService implements ProductSortingService {
    @Override
    public List<Product> sort(List<Product> products) {
        return products
                .stream()
                .sorted(Comparator.comparing(Product::getQuantity))
                .toList();
    }
}
