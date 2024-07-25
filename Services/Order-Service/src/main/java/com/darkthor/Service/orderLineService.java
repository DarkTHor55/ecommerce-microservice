package com.darkthor.Service;

import com.darkthor.Repository.OrderLineRepository;
import com.darkthor.Request.OrderLineRequest;
import com.darkthor.Response.OrderLineResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class orderLineService {
    private final OrderLineMapper mapper;
    private final OrderLineRepository orderLineRepository;

    public Integer saveOrderLine(OrderLineRequest orderLineRequest){
        var order =mapper.toOrderLine(orderLineRequest);
        return orderLineRepository.save(order).getId();
    }
    public List<OrderLineResponse> findAllByOrderId(int orderId) {
        return orderLineRepository.findAllByOrderId(orderId).stream().map(mapper::toOrderLineResponse).collect(Collectors.toList());
    }
}
