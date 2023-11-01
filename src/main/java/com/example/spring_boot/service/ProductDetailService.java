package com.example.spring_boot.service;

import com.example.spring_boot.entity.ProductDetailEntity;
import com.example.spring_boot.payload.request.ProductDetailRequest;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductDetailService {


    Page<ProductDetailEntity> findAllProductDetail(ProductDetailRequest productDetailRequest);

    void delete(Long id);


}
