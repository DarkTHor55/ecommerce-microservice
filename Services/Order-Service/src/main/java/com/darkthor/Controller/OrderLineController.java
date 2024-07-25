package com.darkthor.Controller;

import com.darkthor.Response.OrderLineResponse;
import com.darkthor.Service.orderLineService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/order-line")
@RequiredArgsConstructor
public class OrderLineController {
    private final orderLineService service;
    @GetMapping("/order/{id}")
    public ResponseEntity<List<OrderLineResponse>> findByOrderId(@PathVariable("id")int orderId) {
        return ResponseEntity.ok(service.findAllByOrderId(orderId));
    }

}
