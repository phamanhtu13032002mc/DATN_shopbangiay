package com.example.spring_boot.service;

import com.example.spring_boot.entity.ProductEntity;
import com.example.spring_boot.payload.request.ProductRequest;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    List<ProductEntity> findAll(ProductRequest productRequest);

    ProductEntity findById(Long id);

    List<ProductEntity> findByNameLike(String name);

    void delete(Long id);

    ProductEntity create(ProductEntity productEntity);

    List<ProductEntity> findAllByIsDeleteFalse();

    Optional<ProductEntity> findByID(Long id);
}
