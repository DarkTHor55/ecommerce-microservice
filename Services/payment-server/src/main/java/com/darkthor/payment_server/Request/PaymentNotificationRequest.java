package com.darkthor.payment_server.Request;

import com.darkthor.payment_server.Model.PaymentMethod;
import lombok.*;

import java.math.BigDecimal;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaymentNotificationRequest {
    private String orderRefrerence;
    private BigDecimal amount;
    private PaymentMethod paymentMethod;
    private String customerFirstName;
    private String customerLastName;
    private String customerEmail;
}
