package com.example.spring_boot.payload.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequest {

    private String nameProduct;

    private Double price;//giá gốc

    private Double discount;//giảm %

    @Length(max = 5000)
    private String description;//mô tả

    @Length(max = 5000)
    private String descriptionDetail;//mô tả chi tiết

    private String status;//trạng thái

    private Date date_update;
    private Date date_create;
    private String image;//hình ảnh

    private Long page;
    private Long size;
    private Long idSize;
    private Long idProperties;


}
