package com.darkthor.Service;

import com.darkthor.Repository.OrderLineRepository;
import com.darkthor.Request.OrderLineRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderLineService {
    private final OrderLineRepository orderLineRepository;
    private final OrderLineMapper mapper;
    public Integer saveOrderLine(OrderLineRequest orderLineRequest) {
        var order =mapper.toOrderLine(orderLineRequest);
        return orderLineRepository.save(order).getId();
    }
}
