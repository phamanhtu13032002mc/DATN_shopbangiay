package com.example.spring_boot.service;

import com.example.spring_boot.payload.request.ProductDetailRequest;

import java.util.List;

public interface ProductDetailService {


     List<Object[]> findAllProduct(ProductDetailRequest productDetailRequest);

    void delete(Long id);


}
