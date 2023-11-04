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
    private Long id;
    private String fullName;

    private String address;


    private Long phone;


    private Long id_address;


    private String email;
    private Long size;
    private Long page;
}
