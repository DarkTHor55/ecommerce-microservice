package com.darkthor.product_server.Request;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductPurchaseRequest {
    @NotNull(message = "ProductId must needed")
    private int productId;
    @NotNull(message = "quantity must be positive")
    private double quantity;
}
