package com.example.spring_boot.payload.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateQuantityProductRequest {
    private long   productId;
    private long  quantity;

    private String   nameSize;
    private String   nameProperty;

}
