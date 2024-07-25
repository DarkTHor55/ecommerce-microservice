package com.darkthor.Request;

import com.darkthor.Model.PaymentMethod;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderRequest {
    private int id;
    private String reference;
    @Positive(message = "Order amount shouldbe positive")
    private BigDecimal amount;
    @NotNull(message = "Payment should not be null")
    private PaymentMethod paymentMethod;
    @NotNull(message = "coustomer should not be presnt")
    @NotEmpty(message = "coustomer should not be presnt")
    @NotBlank(message = "coustomer should not be presnt")
    private int customerId;
    @NotEmpty(message = "You should purchase atleast  one product")
    private List<PurchaseRequest> products;


}
