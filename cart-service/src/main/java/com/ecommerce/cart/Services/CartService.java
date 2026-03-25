package com.ecommerce.cart.Services;

import com.ecommerce.cart.DTO.CartItem;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class CartService {
    private final RedisTemplate<String, Object> redisTemplate;

    private static final String CART_PREFIX = "cart:";

    //  Add item to cart
    public void addToCart(String userEmail , CartItem item) {

        String key = CART_PREFIX + userEmail;

        redisTemplate.opsForHash()
                .put(key, item.getProductId(), item.getQuantity());
    }

    //  Get full cart
    public Map<Object, Object> getCart(String userEmail) {

        String key = CART_PREFIX + userEmail;

        return redisTemplate.opsForHash().entries(key);
    }

    //  Remove item
    public void removeFromCart(String userEmail, String productId) {

        String key = CART_PREFIX + userEmail;

        redisTemplate.opsForHash().delete(key, productId);
    }

    // Clear cart
    public void clearCart(String userEmail) {

        String key = CART_PREFIX + userEmail;

        redisTemplate.delete(key);
    }
}
