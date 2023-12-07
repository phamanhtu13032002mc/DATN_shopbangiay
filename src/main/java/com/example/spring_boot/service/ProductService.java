package com.example.spring_boot.service;

import com.example.spring_boot.entity.ProductEntity;
import com.example.spring_boot.payload.DataObj;
import com.example.spring_boot.payload.request.CreateProduct;
import com.example.spring_boot.payload.request.ProductRequest;
import com.example.spring_boot.payload.request.UpdateQuantityProductRequest;
import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

import javax.xml.crypto.Data;
import java.util.Optional;

public interface ProductService {
    ProductEntity findById(Long id);

    Page<Object[]> findAllProduct(ProductRequest productRequest);
    DataObj findByIdProduct(Long idProduct);


    DataObj delete(Long idProduct);


    Optional<ProductEntity> findByID(Long id);

    DataObj save( CreateProduct createProduct);

    DataObj findAllProductByName(String name);
    DataObj updateQuantityProduct(UpdateQuantityProductRequest quantityProductReques);



}
