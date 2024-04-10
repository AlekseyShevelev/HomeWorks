package org.example.simplemarket.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class MarketAccount {
    private long id;
    private String name;
    private BigDecimal amount;
}
