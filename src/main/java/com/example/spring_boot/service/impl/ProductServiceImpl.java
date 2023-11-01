package com.example.spring_boot.service.impl;

import com.example.spring_boot.entity.ProductEntity;
import com.example.spring_boot.payload.request.ProductDetailRequest;
import com.example.spring_boot.payload.request.ProductRequest;
import com.example.spring_boot.repository.ProductDetailRepository;
import com.example.spring_boot.repository.ProductRepository;
import com.example.spring_boot.service.ProductService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService {
    private final Path root = Paths.get("saveImg");

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductDetailRepository productDetailRepository;


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
    public Optional<ProductEntity> findByID(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public String save(MultipartFile file, ProductRequest productRequest) {
        try {
            if (file != null) {
                String filename = file.getOriginalFilename();
                UUID uuid = UUID.randomUUID();
                filename = uuid + ".jpg";
                Files.copy(file.getInputStream(), this.root.resolve(filename));
                productRequest.setImage("http://localhost:8080/image/get/"+ filename);
            }

            return "data";
        } catch (Exception e) {
            // TODO: handle exception
            return "lỗi" +e;
        }
    }

}
