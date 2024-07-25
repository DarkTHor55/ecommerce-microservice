package com.darkthor.Request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;
import org.springframework.stereotype.Service;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PurchaseRequest {
    @NotNull(message = "product s mandatory")
    private int productId;
    @Positive(message = "quantity is mandatory")
    private double quantity;

}
