package com.example.spring_boot.payload.request;

import lombok.*;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDetailRequest {
    private Long id;
    private Long quantityBill;
    private Long page;
    private Long size;

}
