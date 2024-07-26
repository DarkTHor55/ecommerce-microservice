package com.darkthor.payment_server.Service;

import com.darkthor.payment_server.Repository.PaymentRepository;
import com.darkthor.payment_server.Request.PaymentNotificationRequest;
import com.darkthor.payment_server.Request.PaymentRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentService {
    private final PaymentRepository paymentRepository;
    private final PaymentMapper mapper;
    private final NotificationProducer notificationProducer;

    public Integer createPayment(PaymentRequest request) {
        var payment = paymentRepository.save(mapper.toPayment(request));
        notificationProducer.sendNotification(
                new PaymentNotificationRequest(
                        request.getOrderReference(),
                        request.getAmount(),
                        request.getPaymentMethod(),
                        request.getCustomer().getFirstName(),
                        request.getCustomer().getLastName(),
                        request.getCustomer().getEmail()
                )
        );  // Send notification to Kafka topic
        return payment.getId();
    }
}
