package com.example.spring_boot.service;

import com.example.spring_boot.entity.ProductDetailEntity;
import com.example.spring_boot.payload.request.ProductDetailRequest;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProducDetailService {

    void delete(Long id);


    Page<ProductDetailEntity> findAllProductDetail(ProductDetailRequest productDetailRequest);
}
