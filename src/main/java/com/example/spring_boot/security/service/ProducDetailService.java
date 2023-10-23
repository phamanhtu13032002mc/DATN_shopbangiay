package com.example.spring_boot.security.service;

import com.example.spring_boot.entity.ProductDetailEntity;

import java.util.List;

public interface ProducDetailService {

    List<ProductDetailEntity> findAll();

    List<ProductDetailEntity> findAllByIsDeleteFalse();


    void delete(Long id);


}
