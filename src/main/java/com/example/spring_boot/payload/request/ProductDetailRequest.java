package com.example.spring_boot.payload.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDetailRequest {
    private Long id;
    private Long quantity;
    private Long idProduct;
    private Long idProperty;
    private Long idSize;
    private Boolean isDelete ;
    private Long page;
    private Long size;
}
