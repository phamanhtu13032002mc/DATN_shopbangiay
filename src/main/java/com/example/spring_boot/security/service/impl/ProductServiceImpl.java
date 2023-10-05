package com.example.spring_boot.security.service.impl;

import com.example.spring_boot.entity.Product;
import com.example.spring_boot.repository.ProductRepository;
import com.example.spring_boot.security.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(Long id) {
        return productRepository.findById(id).get();
    }

    @Override
    public List<Product> findByNameLike(String name) {
        return null;
    }

    @Override
    public void delete(Long id) {
        Product product = productRepository.findById(id).get();
        product.setIsDelete(true);
        productRepository.save(product);

    }

    @Override
    public Product create(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> findAllByIsDeleteFalse() {
        return productRepository.findAllByIsDeleteFase();
    }
}
