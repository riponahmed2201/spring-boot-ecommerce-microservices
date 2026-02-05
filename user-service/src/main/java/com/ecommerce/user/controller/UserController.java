package com.ecommerce.user.controller;

import com.ecommerce.user.dto.LoginRequestDto;
import com.ecommerce.user.dto.LoginResponseDto;
import com.ecommerce.user.dto.UserCreateRequestDto;
import com.ecommerce.user.dto.UserResponseDto;
import com.ecommerce.user.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserResponseDto> register(@Valid @RequestBody UserCreateRequestDto dto) {
        UserResponseDto created = userService.register(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @GetMapping("/login")
    public ResponseEntity<LoginResponseDto> login(@Valid @RequestBody LoginRequestDto dto) {
        LoginResponseDto loginResponseDto = userService.login(dto);
        return ResponseEntity.ok(loginResponseDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> getById(@PathVariable Long id, Authentication authentication) {
        UserResponseDto userResponseDto = userService.getById(id);
        return ResponseEntity.ok(userResponseDto);
    }
}
