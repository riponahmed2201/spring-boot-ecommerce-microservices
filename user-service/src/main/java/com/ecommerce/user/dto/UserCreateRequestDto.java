package com.ecommerce.user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserCreateRequestDto {
    @NotBlank(message = "Name is Required")
    private String name;
    @Email(message = "Valid Email is Required")
    @NotBlank(message = "Email is Required")
    private String email;
    @NotBlank(message = "Password is Required")
    @Size(message = "Password must be at least 6 characters")
    private String password;
    private String phone;
}
