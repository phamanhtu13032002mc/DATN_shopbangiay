package com.example.spring_boot.service.impl;

import com.example.spring_boot.entity.ProductDetailEntity;
import com.example.spring_boot.payload.request.ProductDetailRequest;
import com.example.spring_boot.repository.ProductDetailRepository;
import com.example.spring_boot.service.ProducDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProducDetailServiceImpl implements ProducDetailService {
    @Autowired
    ProductDetailRepository productDetailRepository;



    @Override
    public void delete(Long id) {
     ProductDetailEntity productdetail = productDetailRepository.findById(id).get();
     productdetail.setIsDelete(true);
     productDetailRepository.save(productdetail);
    }

    @Override
    public Page<ProductDetailEntity> findAllProductDetail(ProductDetailRequest productDetailRequest) {
        Pageable pageable = PageRequest.of(Math.toIntExact(productDetailRequest.getPage()), Math.toIntExact(productDetailRequest.getSizePage()));
        return productDetailRepository.findAllProductDetail(productDetailRequest, pageable);
    }
}
