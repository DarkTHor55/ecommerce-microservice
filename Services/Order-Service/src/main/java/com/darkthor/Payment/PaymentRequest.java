package com.darkthor.Payment;

import com.darkthor.Model.PaymentMethod;
import com.darkthor.Response.CustomerResponse;
import lombok.*;

import java.math.BigDecimal;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaymentRequest {
    private int id;
    private BigDecimal amount;
    private PaymentMethod paymentMethod;
    private int orderId;
    private String orderReference;
    private CustomerResponse customer;

    public PaymentRequest(BigDecimal amount, PaymentMethod paymentMethod, int id, String reference, CustomerResponse customer) {
        this.amount = amount;
        this.paymentMethod = paymentMethod;
        this.id = id;
        this.orderReference = reference;
        this.customer = customer;
    }
}
