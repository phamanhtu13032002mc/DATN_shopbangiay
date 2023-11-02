package com.example.spring_boot.service;

import com.example.spring_boot.payload.request.ProductDetailRequest;
import org.springframework.data.domain.Page;

public interface ProductDetailService {


     Page<Object[]> findAllProduct(ProductDetailRequest productDetailRequest);

    void delete(Long id);


}
