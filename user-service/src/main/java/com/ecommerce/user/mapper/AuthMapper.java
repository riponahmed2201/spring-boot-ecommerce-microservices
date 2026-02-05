package com.ecommerce.user.mapper;

import com.ecommerce.user.dto.LoginResponseDto;
import com.ecommerce.user.entity.User;

public class AuthMapper {
    public LoginResponseDto toLoginResponse(User user, String token) {
        return new LoginResponseDto(token, "Bearer", user.getId(), user.getEmail(), user.getName());
    }
}
