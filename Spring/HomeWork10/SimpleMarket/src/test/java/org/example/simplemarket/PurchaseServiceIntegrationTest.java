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
import org.springframework.boot.test.mock.mockito.MockBean;

import java.math.BigDecimal;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@SpringBootTest
public class PurchaseServiceIntegrationTest {
    @MockBean
    private MarketAccountRepository marketAccountRepository;

    @MockBean
    private UserAccountRepository userAccountRepository;

    @MockBean
    private ProductRepository productRepository;

    @Autowired
    private PurchaseService purchaseService;

    @Test
    public void testPurchaseSuccess() {
        // Pre
        Product product = new Product();
        product.setId(1);
        product.setName("Product 1");
        product.setPrice(BigDecimal.valueOf(100));
        product.setQuantity(50);

        UserAccount userAccount = new UserAccount();
        userAccount.setId(1);
        userAccount.setName("User account 1");
        userAccount.setAmount(BigDecimal.valueOf(2000));

        MarketAccount marketAccount = new MarketAccount();
        marketAccount.setId(1);
        marketAccount.setName("Market account 2");
        marketAccount.setAmount(BigDecimal.valueOf(10000));

        given(productRepository.getProductById(product.getId()))
                .willReturn(product);
        given(userAccountRepository.getUserAccountById(userAccount.getId()))
                .willReturn(userAccount);
        given(marketAccountRepository.getMarketAccountById(marketAccount.getId()))
                .willReturn(marketAccount);

        // Action
        purchaseService.buyProduct(1, 5, 1, 1);

        // Checks
        verify(productRepository).changeQuantity(1, 45);
        verify(userAccountRepository).changeAmount(1, BigDecimal.valueOf(1500));
        verify(marketAccountRepository).changeAmount(1, BigDecimal.valueOf(10500));
    }
}
