package com.darkthor.payment_server.Request;

import com.darkthor.payment_server.Model.Customer;
import com.darkthor.payment_server.Model.Payment;
import com.darkthor.payment_server.Model.PaymentMethod;
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
    private Customer customer;

}
