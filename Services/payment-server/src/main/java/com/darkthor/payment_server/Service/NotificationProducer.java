package com.darkthor.payment_server.Service;

import com.darkthor.payment_server.Model.PaymentMethod;
import com.darkthor.payment_server.Request.PaymentNotificationRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class NotificationProducer {
    private KafkaTemplate<String , PaymentNotificationRequest> kafkaTemplate;
    public void sendNotification(PaymentNotificationRequest request){
        log.info("Sending payment notification: {}", request);
        Message<PaymentNotificationRequest>message= MessageBuilder
                .withPayload(request)
                .setHeader(KafkaHeaders.TOPIC,"payment-topic")
                .build();
        kafkaTemplate.send( message);
        log.info("Payment notification sent successfully");
    }
}