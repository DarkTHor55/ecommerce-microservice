package com.darkthor.Kafka;

import com.darkthor.Model.Notification;
import com.darkthor.Model.NotificationType;
import com.darkthor.Repository.NotificationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.logging.Logger;

@Service
@RequiredArgsConstructor
@Slf4j
public class NotificationConsumer {
    private final Logger logger = (Logger) LoggerFactory.getLogger(NotificationConsumer.class);
    private final NotificationRepository notificationRepository;
    @KafkaListener(topics = "payment-topic")
    public void consumePaymentConfirmationNotification(PaymentConfirmation paymentConfirmation) {
        logger.info(String.format("Consuming the message from payment-topicTopic ::%s ", paymentConfirmation));
        notificationRepository.save(Notification.builder()
                    .notificationType(NotificationType.PAYMENT_CONFIRMATION)
                        .notificationDate(LocalDateTime.now())
                        .paymentConfirmation(paymentConfirmation)

                .build());
//  todo send email


    }
    @KafkaListener(topics = "order-topic")
    public void consumeOrderConfirmationNotification(OrderConfirmation orderConfirmation) {
        logger.info(String.format("Consuming the message from payment-topicTopic ::%s ", orderConfirmation));
        notificationRepository.save(Notification.builder()
                .notificationType(NotificationType.ORDER_CONFIRMATION)
                .notificationDate(LocalDateTime.now())
                .orderConfirmation(orderConfirmation)

                .build());
//  todo send email


    }

}
