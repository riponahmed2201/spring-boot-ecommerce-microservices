package com.ecommerce.user.service.impl;

import com.ecommerce.user.dto.LoginRequestDto;
import com.ecommerce.user.dto.LoginResponseDto;
import com.ecommerce.user.dto.UserCreateRequestDto;
import com.ecommerce.user.dto.UserResponseDto;
import com.ecommerce.user.entity.User;
import com.ecommerce.user.exception.ResourceAlreadyExistsException;
import com.ecommerce.user.exception.ResourceNotFoundException;
import com.ecommerce.user.mapper.AuthMapper;
import com.ecommerce.user.mapper.UserMapper;
import com.ecommerce.user.repository.UserRepository;
import com.ecommerce.user.service.UserService;
import com.ecommerce.user.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private UserMapper userMapper;
    private PasswordEncoder passwordEncoder;
    private JwtUtil jwtUtil;
    private AuthMapper authMapper;

    @Override
    public UserResponseDto register(UserCreateRequestDto dto) {

//        if (userRepository.existsByEmail(dto.getEmail())) {
//            throw new RuntimeException("Email already exists");
//        }
//
//        User user = new User();
//        user.setName(dto.getName());
//        user.setEmail(dto.getEmail());
//        user.setPassword(dto.getPassword());
//
//        User savedUser = userRepository.save(user);
//        return new UserResponseDto();

        if (userRepository.existsByEmail(dto.getEmail())) {
            throw new ResourceAlreadyExistsException("Email Already Exists");
        }

        User user = userMapper.toEntity(dto);
        User result = userRepository.save(user);
        return userMapper.toDto(result);
    }

    @Override
    public LoginResponseDto login(LoginRequestDto dto) {
        User user = userRepository.findByEmail(dto.getEmail()).orElseThrow(() -> new ResourceNotFoundException("Invalid Credentials"));
        boolean matches = passwordEncoder.matches(user.getPassword(), dto.getPassword());

        if (!matches) {
            throw new ResourceNotFoundException("Invalid Credentials");
        }

        String token = jwtUtil.generateToken(user.getId(), user.getEmail(), user.getRoles());
        return authMapper.toLoginResponse(user, token);
    }

    @Override
    public UserResponseDto getById(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found" + id));
        return userMapper.toDto(user);
    }
}
