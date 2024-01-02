package com.example.spring_boot.payload.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.web.multipart.MultipartFile;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateProductRequest {
    private Long id;
    private String nameProduct;

    private Double price;//giá gốc

// private Double discount;//giảm %

    @Length(max = 5000)
    private String description;//mô tả

    @Length(max = 5000)
    private String descriptionDetail;//mô tả chi tiết

    private String status;//trạng thái

    private Long quantity;

    private MultipartFile image;//hình ảnh
    private Long idCategory;
    private String categoryName;

    private Long idSize;
    private Long idProperties;

}
