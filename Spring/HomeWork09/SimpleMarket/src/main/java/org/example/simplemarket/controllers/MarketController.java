package org.example.simplemarket.controllers;

import org.example.simplemarket.dto.PurchaseRequest;
import org.example.simplemarket.model.MarketAccount;
import org.example.simplemarket.model.Product;
import org.example.simplemarket.model.UserAccount;
import org.example.simplemarket.services.PurchaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/market")
public class MarketController {
    private final PurchaseService purchaseService;

    @PostMapping("/purchase")
    public void buyProduct(@RequestBody PurchaseRequest request) {
        purchaseService.buyProduct(
                request.getProductId(),
                request.getQuantity(),
                request.getMarketAccountId(),
                request.getUserAccountId());
    }

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return purchaseService.getAllProducts();
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
