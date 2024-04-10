package org.example.simplemarket;

import org.example.simplemarket.model.MarketAccount;
import org.example.simplemarket.model.Product;
import org.example.simplemarket.model.UserAccount;
import org.example.simplemarket.repository.MarketAccountRepository;
import org.example.simplemarket.repository.ProductRepository;
import org.example.simplemarket.repository.UserAccountRepository;
import org.example.simplemarket.services.PurchaseService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class PurchaseServiceUnitTests {
    @Mock
    private MarketAccountRepository marketAccountRepository;

    @Mock
    private UserAccountRepository userAccountRepository;

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
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

    @Test
    public void testPurchaseUserAccountNotFound() {
        // Pre
        Product product = new Product();
        product.setId(1);
        product.setName("Product 1");
        product.setPrice(BigDecimal.valueOf(100));
        product.setQuantity(50);

        MarketAccount marketAccount = new MarketAccount();
        marketAccount.setId(1);
        marketAccount.setName("Market account 2");
        marketAccount.setAmount(BigDecimal.valueOf(10000));

        given(productRepository.getProductById(product.getId()))
                .willReturn(product);
        given(marketAccountRepository.getMarketAccountById(marketAccount.getId()))
                .willReturn(marketAccount);
        given(userAccountRepository.getUserAccountById(1))
                .willReturn(null);

        assertThrows(
                RuntimeException.class,
                () -> purchaseService.buyProduct(1, 5, 1, 1)
        );

        verify(productRepository, never())
                .changeQuantity(anyLong(), anyInt());
        verify(userAccountRepository, never())
                .changeAmount(anyLong(), any());
    }
}
