package com.darkthor.payment_server.Service;

import com.darkthor.payment_server.Model.Payment;
import com.darkthor.payment_server.Request.PaymentRequest;

public class PaymentMapper {
    public Payment toPayment(PaymentRequest request) {
        return  Payment.builder()
                .id(request.getId())
                .orderId(request.getOrderId())
                .amount(request.getAmount())
                .paymentMethod(request.getPaymentMethod())
                .build();
    }
}
