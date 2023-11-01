package com.example.spring_boot.payload.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateProductDetail {

    private Long quantity;
    private Long idpoduct;
    private Long idsize;
    private List<PropertiesRequest> propertyrequest;
}
