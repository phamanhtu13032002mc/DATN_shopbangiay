package com.example.spring_boot.payload.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
@Data
@AllArgsConstructor
@NoArgsConstructor

public class SaveUserRequest {
    private String fullName;
    private String address;
    private String phone;
    private String email;
    private String password;
    private String username;



}
