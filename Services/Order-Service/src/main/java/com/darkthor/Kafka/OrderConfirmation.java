package com.darkthor.Kafka;

import com.darkthor.Model.PaymentMethod;
import com.darkthor.Request.PurchaseRequest;
import com.darkthor.Response.CustomerResponse;
import com.darkthor.Response.PurchaseResponse;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor@Builder
public class OrderConfirmation {
    private String orderReference;

    private BigDecimal totalAmount;
    private PaymentMethod paymentMethod;
    private CustomerResponse customer;
    private List<PurchaseResponse> products;
}
