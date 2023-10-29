package com.example.spring_boot.service.impl;

import com.example.spring_boot.entity.ProductEntity;
import com.example.spring_boot.payload.request.ProductRequest;
import com.example.spring_boot.repository.ProductRepository;
import com.example.spring_boot.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;


    @Override
    public ProductEntity findById(Long id) {
        return productRepository.findById(id).get();
    }

    @Override
    public Page<ProductEntity> findAllProduct(ProductRequest productRequest) {
        Pageable pageable = PageRequest.of(Math.toIntExact(productRequest.getPage()), Math.toIntExact(productRequest.getSize()));
        return productRepository.findAllProduct(productRequest, pageable);
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
    public Optional<ProductEntity> findByID(Long id) {
        return productRepository.findById(id);
    }

}
