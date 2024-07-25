package com.darkthor.Service;

import com.darkthor.Model.Orders;
import com.darkthor.Request.OrderRequest;
import com.darkthor.Response.OrderResonse;
import org.springframework.stereotype.Service;

@Service
public class OrderMapper {
    public Orders toOrder(OrderRequest orderRequest) {
        return Orders.builder()
                .id(orderRequest.getId())
                .customerId(orderRequest.getCustomerId())
                .refrence(orderRequest.getReference())
                .totalAmount(orderRequest.getAmount())
                .paymentMethod(orderRequest.getPaymentMethod())
                .build();
    }

    public OrderResonse fromOrder(Orders orders) {
        return new OrderResonse(
                orders.getId(),
                orders.getCustomerId(),
                orders.getRefrence(),
                orders.getTotalAmount(),
                orders.getPaymentMethod()
        );
    }
}
