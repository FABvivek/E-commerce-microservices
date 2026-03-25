package com.ecommerce.cart.Controller;

import com.ecommerce.cart.DTO.CartItem;
import com.ecommerce.cart.Services.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/cart")
@RequiredArgsConstructor
public class CartController {
    private final CartService service;

    @PreAuthorize("hasRole('USER')")
    @PostMapping
    public String addToCart(@RequestBody CartItem item,
                            Authentication auth) {

        String userEmail = auth.getName();

        service.addToCart(userEmail, item);
        return "Item added";
    }

    // 📄 Get cart
    @PreAuthorize("hasRole('USER')")
    @GetMapping
    public Map<Object, Object> getCart(Authentication auth) {

        String userEmail = auth.getName();

        return service.getCart(userEmail);
    }

    // ❌ Remove item
    @PreAuthorize("hasRole('USER')")
    @DeleteMapping("/{productId}")
    public String remove(@PathVariable String productId,
                         Authentication auth) {

        String userEmail = auth.getName();

        service.removeFromCart(userEmail, productId);
        return "Removed";
    }

    // 🧹 Clear cart
    @PreAuthorize("hasRole('USER')")
    @DeleteMapping("/clear")
    public String clear(Authentication auth) {

        String userEmail = auth.getName();

        service.clearCart(userEmail);
        return "Cleared";
    }
}
