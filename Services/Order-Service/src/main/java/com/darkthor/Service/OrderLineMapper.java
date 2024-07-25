package com.darkthor.Service;

import com.darkthor.Model.OrderLine;
import com.darkthor.Model.Orders;
import com.darkthor.Request.OrderLineRequest;
import com.darkthor.Response.OrderLineResponse;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderLineMapper {
    public OrderLine toOrderLine(OrderLineRequest orderLineRequest) {
        return OrderLine.builder()
                .id(orderLineRequest.getId())
                .productId(orderLineRequest.getProductId())
                .quantity(orderLineRequest.getQuantity())
                .order(Orders.builder()
                        .id(orderLineRequest.getOrderId())

                        .build())
                .build();
    }

    public OrderLineResponse toOrderLineResponse(OrderLine orderLine) {
        return  new OrderLineResponse(orderLine.getId() ,orderLine.getQuantity());
    }
}
