package org.example.simplemarket.controllers;

import org.example.simplemarket.dto.PurchaseRequest;
import org.example.simplemarket.model.MarketAccount;
import org.example.simplemarket.model.Product;
import org.example.simplemarket.model.UserAccount;
import org.example.simplemarket.services.FileGateway;
import org.example.simplemarket.services.PurchaseService;
import lombok.RequiredArgsConstructor;
import org.example.simplemarket.services.factory.ProductSortingFactory;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/market")
public class MarketController {
    final static DateTimeFormatter CUSTOM_FORMATTER = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");

    private final PurchaseService purchaseService;
    private final FileGateway fileGateway;
    private final ProductSortingFactory productSortingFactory;

    @PostMapping("/purchase")
    public void buyProduct(@RequestBody PurchaseRequest request) {
        purchaseService.buyProduct(
                request.getProductId(),
                request.getQuantity(),
                request.getMarketAccountId(),
                request.getUserAccountId());

        String fileSuffix = LocalDateTime.now().format(CUSTOM_FORMATTER);
        fileGateway.writeToFile("Purchase_" + fileSuffix + ".txt", request.toString());
    }

    @GetMapping("/products")
    public List<Product> getAllProducts(@RequestParam(required = false) String sortBy) {
        List<Product> products = purchaseService.getAllProducts();

        if (sortBy == null) {
            return products;
        } else {
            return productSortingFactory.getSortingService(sortBy).sort(products);
        }
    }

    @GetMapping("/market_accounts")
    public List<MarketAccount> getAllMarketAccounts() {
        return purchaseService.getAllMarketAccounts();
    }

    @GetMapping("/user_accounts")
    public List<UserAccount> getAllUserAccounts() {
        return purchaseService.getAllUserAccounts();
    }
}
