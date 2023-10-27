package com.example.spring_boot.service;

import com.example.spring_boot.entity.ProductDetailEntity;
import com.example.spring_boot.payload.request.ProductDetailRequest;

import java.util.List;

public interface ProducDetailService {

    List<ProductDetailEntity> findAll(ProductDetailRequest productDetailRequest);

    List<ProductDetailEntity> findAllByIsDeleteFalse();


    void delete(Long id);


}
