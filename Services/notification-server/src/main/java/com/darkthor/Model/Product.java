package com.darkthor.Model;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.math.BigDecimal;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {
    private int productId;
    private String name;
    private String description;
    private BigDecimal price;
    private Double availableQuantity;

}
