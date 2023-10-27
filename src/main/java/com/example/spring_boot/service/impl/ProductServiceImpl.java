package com.example.spring_boot.service.impl;

import com.example.spring_boot.entity.ProductEntity;
import com.example.spring_boot.payload.request.ProductRequest;
import com.example.spring_boot.repository.ProductRepository;
import com.example.spring_boot.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public List<ProductEntity> findAll(ProductRequest productRequest) {
        return productRepository.findAll();
    }

    @Override
    public ProductEntity findById(Long id) {
        return productRepository.findById(id).get();
    }

    @Override
    public List<ProductEntity> findByNameLike(String name) {
        return null;
    }

    @Override
    public void delete(Long id) {
        ProductEntity productEntity = productRepository.findById(id).get();
        productEntity.setIsDelete(true);
        productRepository.save(productEntity);

    }

    @Override
    public ProductEntity create(ProductEntity productEntity) {
        return productRepository.save(productEntity);
    }

    @Override
    public List<ProductEntity> findAllByIsDeleteFalse() {
        return productRepository.findAllByIsDeleteFase();
    }

    @Override
    public Optional<ProductEntity> findByID(Long id) {
        return productRepository.findById(id);
    }
}
