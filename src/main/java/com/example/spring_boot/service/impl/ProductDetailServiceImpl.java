package com.example.spring_boot.service.impl;

import com.example.spring_boot.entity.ProductDetailEntity;
import com.example.spring_boot.payload.request.ProductDetailRequest;
import com.example.spring_boot.repository.ProductDetailRepository;
import com.example.spring_boot.service.ProductDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductDetailServiceImpl implements ProductDetailService {
    @Autowired
    ProductDetailRepository productDetailRepository;
    @Override
    public List<Object[]> findAllProduct(ProductDetailRequest productDetailRequest) {
        return productDetailRepository.findAllProductDetail();
    }


    @Override
    public void delete(Long id) {
     ProductDetailEntity productdetail = productDetailRepository.findById(id).get();
     productdetail.setIsDelete(true);
     productDetailRepository.save(productdetail);
    }

}
