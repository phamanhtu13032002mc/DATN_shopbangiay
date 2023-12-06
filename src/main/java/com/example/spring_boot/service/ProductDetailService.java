package com.example.spring_boot.service;

import com.example.spring_boot.payload.DataObj;
import com.example.spring_boot.payload.request.ProductDetailRequest;
import org.springframework.data.domain.Page;

public interface ProductDetailService {


    void delete(Long id);

    DataObj findProductDetailByProduct(ProductDetailRequest productDetailRequest);

}
