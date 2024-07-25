package com.darkthor.Response;

import com.darkthor.Model.PaymentMethod;
import lombok.*;

import java.math.BigDecimal;
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderResonse {
    private int id;
    private String reference;
    private BigDecimal amount;
    private PaymentMethod paymentMethod;
    private int customerId;

    public OrderResonse(int id, int customerId, String refrence, BigDecimal totalAmount, PaymentMethod paymentMethod) {
        this.id = id;
        this.customerId = customerId;
        this.reference = refrence;
        this.amount = totalAmount;
        this.paymentMethod = paymentMethod;
    }
}
