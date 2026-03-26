package com.ecommerce.order.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaProducerService {
    private final KafkaTemplate<String, String> kafkaTemplate;
    private static final String TOPIC = "order-events";

    public void sendOrderEvent(String message){
        System.out.println("Sending to Kafka: " + message);
        kafkaTemplate.send(TOPIC, message);
    }
}
