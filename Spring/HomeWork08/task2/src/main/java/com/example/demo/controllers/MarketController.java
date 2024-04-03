package com.example.demo.controllers;

import com.example.demo.dto.PurchaseRequest;
import com.example.demo.model.MarketAccount;
import com.example.demo.model.Product;
import com.example.demo.model.UserAccount;
import com.example.demo.services.PurchaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
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
