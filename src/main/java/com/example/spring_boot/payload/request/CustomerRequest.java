package com.example.spring_boot.payload.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerRequest {
    @NotBlank
    private String fullName;

    private String address;

    @NotBlank
    private long phone;


    private long id_address;

    @NotBlank
    private long email;
}
