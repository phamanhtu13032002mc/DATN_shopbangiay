package com.example.spring_boot.security.service.impl;

import com.example.spring_boot.entity.ProductDetailEntity;
import com.example.spring_boot.repository.ProductDetailRepository;
import com.example.spring_boot.security.service.ProducDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProducDetailServiceImpl implements ProducDetailService {
    @Autowired
    ProductDetailRepository productDetailRepository;
    @Override
    public List<ProductDetailEntity> findAll() {
        return productDetailRepository.findAll();
    }

    @Override
    public List<ProductDetailEntity> findAllByIsDeleteFalse() {
        return productDetailRepository.findAllByIsDeleteFase();
    }



    @Override
    public void delete(Long id) {
     ProductDetailEntity productdetail = productDetailRepository.findById(id).get();
     productdetail.setIsDelete(true);
     productDetailRepository.save(productdetail);
    }
}
