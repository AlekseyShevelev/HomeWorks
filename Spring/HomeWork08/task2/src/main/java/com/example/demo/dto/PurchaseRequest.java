package com.example.demo.dto;

import lombok.Data;

@Data
public class PurchaseRequest {
    private long productId;
    private int quantity;
    private long marketAccountId;
    private long userAccountId;
}
