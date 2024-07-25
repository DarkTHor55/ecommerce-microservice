package com.darkthor.Response;

import org.hibernate.Interceptor;

import java.math.BigDecimal;

public class PurchaseResponse {
    private int id;
    private String name;
    private String description;
    private double quantity;
    private BigDecimal price;
}
