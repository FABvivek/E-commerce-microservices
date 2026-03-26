package com.ecommerce.order.Controller;

import com.ecommerce.order.Entity.Order;
import com.ecommerce.order.Service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public Order placeOrder(@RequestBody List<String> items, Authentication auth){
        String email = auth.getName();
        return orderService.placeOrder(email, items, 10000);

    }
}
