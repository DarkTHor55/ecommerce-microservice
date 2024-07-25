package com.darkthor.Request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class PurchaeRequest {
    @NotNull(message = "product s mandatory")
    private int productId;
    @Positive(message = "quantity is mandatory")
    private double quantity;

}
