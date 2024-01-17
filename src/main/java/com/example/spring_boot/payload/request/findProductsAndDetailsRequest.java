package com.example.spring_boot.payload.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class findProductsAndDetailsRequest {
    private Long id;
    private String nameProduct;
    private Long idColor;
    private Long idSize;
    private Double minPrice;//giá thấp nhất
    private Double maxPrice;//giá cao nhât

    private String description;//mô tả


    private String categoryName;

    private Long page;
    private Long size;

}
