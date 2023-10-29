package com.example.spring_boot.payload.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageableProductRequest {
        private int page;
        private int size;
        private ProductRequest productRequest;

        // Các getter và setter cho các trường

}
