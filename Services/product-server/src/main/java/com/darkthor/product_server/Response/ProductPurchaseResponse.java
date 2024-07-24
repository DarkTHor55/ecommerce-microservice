package com.darkthor.product_server.Response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
@Getter
@Service
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class ProductPurchaseResponse {
    private int id;
    public String name;
    private String description;
    private BigDecimal price;
    private double quantity;

}
