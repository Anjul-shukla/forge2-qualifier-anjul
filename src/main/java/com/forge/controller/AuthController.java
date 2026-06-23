package com.forge.controller;

import com.forge.dto.*;
import com.forge.entity.User;
import com.forge.security.JwtUtil;
import com.forge.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;
    private final AuthenticationManager authManager;
    private final JwtUtil jwtUtil;

    @PostMapping("/register")
    public ResponseEntity<UserResponse> register(@RequestBody RegisterRequest req) {
        User user = userService.register(req);
        UserResponse resp = new UserResponse();
        resp.setId(user.getId().toString());
        resp.setUsername(user.getUsername());
        resp.setEmail(user.getEmail());
        resp.setRoles(user.getRoles().stream().map(r -> r.getName()).toList());
        return ResponseEntity.ok(resp);
    }

    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(@RequestBody LoginRequest req) {
        Authentication auth = authManager.authenticate(
                new UsernamePasswordAuthenticationToken(req.getUsername(), req.getPassword()));
        // Ensure authentication succeeded
        if (auth == null || !auth.isAuthenticated()) {
            return ResponseEntity.status(401).build();
        }
        String token = jwtUtil.generateToken(req.getUsername());
        return ResponseEntity.ok(new JwtResponse(token));
    }
}
