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

    private String fullName;

    private String address;


    private long phone;


    private long id_address;


    private long email;
    private Long size;
    private Long page;
}
