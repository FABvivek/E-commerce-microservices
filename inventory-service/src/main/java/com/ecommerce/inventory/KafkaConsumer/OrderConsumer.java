package com.ecommerce.inventory.KafkaConsumer;

import com.ecommerce.inventory.Repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderConsumer {
    private final ProductRepository productRepository;

    @KafkaListener(topics = "order-events", groupId = "inventory-group")
    public void consume(String message) {
        System.out.println("Received Order Event: " + message);


        productRepository.findAll().forEach(product -> {
            product.setStock(product.getStock() - 1);
            productRepository.save(product);
        });
    }

}
