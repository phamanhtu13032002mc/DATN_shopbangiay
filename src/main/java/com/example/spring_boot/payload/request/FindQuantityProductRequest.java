package com.example.spring_boot.payload.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FindQuantityProductRequest{
    private Long idProperty;
    private Long idSize;

    private Long idProduct;
}