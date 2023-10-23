package com.example.spring_boot.security.service;

import com.example.spring_boot.entity.ProductEntity;

import java.util.List;

public interface ProductService {

    List<ProductEntity> findAll();

    ProductEntity findById(Long id);

    List<ProductEntity> findByNameLike(String name);

    void delete(Long id);

    ProductEntity create(ProductEntity productEntity);

    List<ProductEntity> findAllByIsDeleteFalse();
}
