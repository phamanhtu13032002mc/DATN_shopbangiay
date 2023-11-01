package com.example.spring_boot.service;

import com.example.spring_boot.entity.ProductEntity;
import com.example.spring_boot.payload.request.ProductRequest;
import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

public interface ProductService {
    ProductEntity findById(Long id);

    Page<ProductEntity> findAllProduct(ProductRequest productRequest);
    void delete(Long id);


    Optional<ProductEntity> findByID(Long id);

    String save(MultipartFile file,ProductRequest productRequest);




}
