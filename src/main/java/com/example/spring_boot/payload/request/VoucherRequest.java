package com.example.spring_boot.payload.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VoucherRequest {

    private Long amount;

    private Double discount;

    private String name;

    private Double minimumValue;
}
