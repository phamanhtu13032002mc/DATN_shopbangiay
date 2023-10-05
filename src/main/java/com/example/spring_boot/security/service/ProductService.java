package com.example.spring_boot.security.service;

import com.example.spring_boot.entity.Product;

import java.util.List;

public interface ProductService {

    List<Product> findAll();

    Product findById(Long id);

    List<Product> findByNameLike(String name);

    void delete(Long id);

    Product create(Product product);

    List<Product> findAllByIsDeleteFalse();
}
