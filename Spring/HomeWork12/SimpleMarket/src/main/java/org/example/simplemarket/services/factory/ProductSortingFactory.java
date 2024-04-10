package org.example.simplemarket.services.factory;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@RequiredArgsConstructor
public class ProductSortingFactory {
    private final Map<String, ProductSortingService> productSortingServices;

    public ProductSortingService getSortingService(String type) {
        return productSortingServices.get(type);
    }
}
