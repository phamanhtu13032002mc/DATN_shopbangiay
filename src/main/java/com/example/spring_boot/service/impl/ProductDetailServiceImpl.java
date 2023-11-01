package com.example.spring_boot.service.impl;

import com.example.spring_boot.entity.ProductDetailEntity;
import com.example.spring_boot.payload.request.ProductDetailRequest;
import com.example.spring_boot.repository.ProductDetailRepository;
import com.example.spring_boot.service.ProductDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductDetailServiceImpl implements ProductDetailService {
    @Autowired
    ProductDetailRepository productDetailRepository;


    @Override
    public Page<ProductDetailEntity> findAllProductDetail(ProductDetailRequest productDetailRequest) {
        Pageable pageable = PageRequest.of(Math.toIntExact(productDetailRequest.getPage()), Math.toIntExact(productDetailRequest.getSize()));
        return productDetailRepository.findAllProductDetail(productDetailRequest, pageable);
    }

    @Override
    public void delete(Long id) {

    }
}
