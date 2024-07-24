package com.darkthor.product_server.Request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
@Getter
@Service
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequest {
    private int id;
    @NotNull(message = "Product is required a name")
    private String name;
    @NotNull(message = "Product is required a description")
    private String description;
    @NotNull(message = "Product is required a availableQuantity")
    private Double availableQuantity;
    @NotNull(message = "Product is required a price")
    private BigDecimal price;
    @NotNull(message = "Product is required a category")
    private Integer categoryId;


}
