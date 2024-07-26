package com.darkthor.Kafka;

import com.darkthor.Model.Customer;
import com.darkthor.Model.PaymentMethod;
import com.darkthor.Model.Product;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderConfirmation {
    private String orderReference;
    private BigDecimal totalAmount;
    private PaymentMethod paymentMethod;
    private Customer customer;
    private List<Product>products;
}
