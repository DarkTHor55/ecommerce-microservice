package com.darkthor.payment_server.Controller;

import com.darkthor.payment_server.Request.PaymentRequest;
import com.darkthor.payment_server.Service.PaymentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/payment")
@RequiredArgsConstructor
public class PaymentController {
    private final PaymentService paymentService;

    @PostMapping
    public ResponseEntity<Integer>createPayment(@Valid @RequestBody PaymentRequest request){
        return ResponseEntity.ok(paymentService.createPayment(request));
    }

}
