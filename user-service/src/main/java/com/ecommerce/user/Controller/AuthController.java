package com.ecommerce.user.Controller;

import com.ecommerce.user.DTO.Authlogin;
import com.ecommerce.user.DTO.Authregister;
import com.ecommerce.user.DTO.AuthResponse;
import com.ecommerce.user.Service.AuthService;
import com.ecommerce.user.Util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;
    private final JwtUtil jwtUtil;


    @PostMapping("/register")
    public String register(@RequestBody Authregister request) {
        return authService.register(request);
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody Authlogin request) {
        String token = authService.login(request);
        return new AuthResponse(token);
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/profile")
    public String profile() {

        return "User profile accessed";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/admin")
    public String admin() {
        return "Admin access";
    }

}
