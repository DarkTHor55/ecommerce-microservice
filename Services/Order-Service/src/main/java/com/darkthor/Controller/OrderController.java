package com.darkthor.Controller;

import com.darkthor.Execption.BusinessExecption;
import com.darkthor.Request.OrderRequest;
import com.darkthor.Response.OrderResonse;
import com.darkthor.Service.OrderService;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/order")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PostMapping()
    public ResponseEntity<Integer>createOrder(@Valid @RequestBody OrderRequest orderRequest) throws BusinessExecption {
        return ResponseEntity.ok(orderService.createOrder(orderRequest));
    }
    @GetMapping()
    public ResponseEntity<List<OrderResonse>> findALl(){
        return ResponseEntity.ok(orderService.findAll());
    }
    @GetMapping("{id}")
    public ResponseEntity<OrderResonse> findById(@PathVariable int id) throws BusinessExecption {
        return ResponseEntity.ok(orderService.findOrderById(id));
    }


}
