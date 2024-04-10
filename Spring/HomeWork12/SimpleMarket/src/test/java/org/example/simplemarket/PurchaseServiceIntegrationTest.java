package org.example.simplemarket;

import org.example.simplemarket.model.MarketAccount;
import org.example.simplemarket.model.Product;
import org.example.simplemarket.model.UserAccount;
import org.example.simplemarket.repository.MarketAccountRepository;
import org.example.simplemarket.repository.ProductRepository;
import org.example.simplemarket.repository.UserAccountRepository;
import org.example.simplemarket.services.PurchaseService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class PurchaseServiceIntegrationTest {
    @Autowired
    private MarketAccountRepository marketAccountRepository;

    @Autowired
    private UserAccountRepository userAccountRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private PurchaseService purchaseService;

    @Test
    public void testPurchaseSuccess() {
        // Pre
        Product product = new Product();
        product.setName("Test Product");
        product.setPrice(BigDecimal.valueOf(100));
        product.setQuantity(50);
        productRepository.save(product);
        product = productRepository
                .getAllProducts().stream()
                .filter(p -> p.getName().equals("Test Product"))
                .findFirst().orElse(null);

        UserAccount userAccount = new UserAccount();
        userAccount.setName("User account 1");
        userAccount.setAmount(BigDecimal.valueOf(2000));
        userAccountRepository.save(userAccount);
        userAccount = userAccountRepository
                .getAllUserAccounts().stream()
                .filter(p -> p.getName().equals("User account 1"))
                .findFirst().orElse(null);

        MarketAccount marketAccount = new MarketAccount();
        marketAccount.setName("Market account 2");
        marketAccount.setAmount(BigDecimal.valueOf(10000));
        marketAccountRepository.save(marketAccount);
        marketAccount = marketAccountRepository
                .getAllMarketAccounts().stream()
                .filter(p -> p.getName().equals("Market account 2"))
                .findFirst().orElse(null);

        // Action
        assert product != null;
        assert marketAccount != null;
        assert userAccount != null;
        purchaseService.buyProduct(
                product.getId(),
                5,
                marketAccount.getId(),
                userAccount.getId());

        // Checks
        Product newProduct = productRepository.getProductById(product.getId());
        assertEquals(
                product.getQuantity() - 5,
                newProduct.getQuantity());

        MarketAccount newMarketAccount = marketAccountRepository.getMarketAccountById(marketAccount.getId());
        assertEquals(
                marketAccount.getAmount().add(BigDecimal.valueOf(500)),
                newMarketAccount.getAmount());

        UserAccount newUserAccount = userAccountRepository.getUserAccountById(userAccount.getId());
        assertEquals(
                userAccount.getAmount().subtract(BigDecimal.valueOf(500)),
                newUserAccount.getAmount());
    }
}
