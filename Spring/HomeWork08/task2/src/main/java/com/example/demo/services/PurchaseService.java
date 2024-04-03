package com.example.demo.services;

import com.example.demo.aspects.Loggable;
import com.example.demo.aspects.MeasuringTime;
import com.example.demo.model.MarketAccount;
import com.example.demo.model.Product;
import com.example.demo.model.UserAccount;
import com.example.demo.repository.MarketAccountRepository;
import com.example.demo.repository.ProductRepository;
import com.example.demo.repository.UserAccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PurchaseService {
    private final ProductRepository productRepository;
    private final MarketAccountRepository marketAccountRepository;
    private final UserAccountRepository userAccountRepository;

    @Transactional
    @Loggable
    @MeasuringTime
    public void buyProduct(
            long productId,
            int quantity,
            long marketAccountId,
            long userAccountId) {
        Product product = productRepository.getProductById(productId);
        MarketAccount marketAccount = marketAccountRepository.getMarketAccountById(marketAccountId);
        UserAccount userAccount = userAccountRepository.getUserAccountById(userAccountId);

        int newQuantity = product.getQuantity() - quantity;
        //TODO проверка достаточного количества

        BigDecimal totalPrice = product.getPrice().multiply(BigDecimal.valueOf(quantity));
        BigDecimal userAmount = userAccount.getAmount().subtract(totalPrice);
        //TODO проверка количества денег
        BigDecimal marketAmount = marketAccount.getAmount().add(totalPrice);

        productRepository.changeQuantity(productId, newQuantity);
        userAccountRepository.changeAmount(userAccountId, userAmount);
        marketAccountRepository.changeAmount(marketAccountId, marketAmount);
    }

    @Loggable
    public List<Product> getAllProducts() {
        return productRepository.getAllProducts();
    }

    @Loggable
    public List<MarketAccount> getAllMarketAccounts() {
        return marketAccountRepository.getAllMarketAccounts();
    }

    @Loggable
    public List<UserAccount> getAllUserAccounts() {
        return userAccountRepository.getAllUserAccounts();
    }
}
