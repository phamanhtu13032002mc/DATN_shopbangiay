package com.example.spring_boot.service.impl;

import com.example.spring_boot.entity.*;
import com.example.spring_boot.payload.DataObj;
import com.example.spring_boot.payload.request.ProductDetailRequest;
import com.example.spring_boot.payload.request.ProductRequest;
import com.example.spring_boot.repository.*;
import com.example.spring_boot.service.CategoryService;
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
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService {
    private final Path root = Paths.get("saveImg");

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductDetailRepository productDetailRepository;

    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    SizeRepository sizeRepository;
    @Autowired
    PropertyRepository propertyRepository;


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
    public DataObj delete(ProductRequest productRequest) {
        try {
            ProductEntity productEntity = productRepository.findByIdProduct(productRequest.getId());
            productEntity.setIsDelete(true);
            ProductDetailEntity productDetailEntity = productDetailRepository.findByIdProduct(productRequest.getId());
            productDetailEntity.setIsDelete(true);
            productDetailRepository.save(productDetailEntity);
            productRepository.save(productEntity);
            return new DataObj().setEcode("200").setEdesc("Success");

        } catch (Exception e) {
            e.printStackTrace();
            return new DataObj().setEcode("400").setEdesc("Error");
        }

    }




    @Override
    public Optional<ProductEntity> findByID(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public DataObj save( ProductRequest productRequest) {

        try {
            if(productRequest.getId() == null) {
                DateTimeFormatter formatterCreate = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                ProductEntity product = new ProductEntity();
                ProductDetailEntity productDetail = new ProductDetailEntity();
                Optional<CategoryEntity> category;
                Optional<SizeEntity> size;
                Optional<PropertyEntity> property;
                Optional<ProductEntity> productId;
                ProductDetailEntity productDetailEntity = new ProductDetailEntity();
                if (productRequest.getImage() != null) {
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
                    String formattedDate = LocalDateTime.now().format(formatter);
                    String fileName = productRequest.getImage().getOriginalFilename();
                    fileName = formattedDate + ".jpg";
                    Files.copy(productRequest.getImage().getInputStream(), this.root.resolve(fileName));

                    product.setImage("http://localhost:8080/image/get/" + fileName);
                }

                category = categoryRepository.findById(productRequest.getIdCategory());
                size = sizeRepository.findById(productRequest.getIdSize());
                property = propertyRepository.findById(productRequest.getIdProperties());
                // save danh sách product
                product.setPrice(productRequest.getPrice());
                product.setDiscount(productRequest.getDiscount());
                product.setStatus(productRequest.getStatus());
                product.setNameProduct(productRequest.getNameProduct());
                product.setDescription(productRequest.getDescription());
                product.setDescriptionDetail(productRequest.getDescriptionDetail());
                product.setCategoryEntity(category.get());
                product.setDate_create(LocalDate.now());
                ProductEntity entity = productRepository.save(product);
                productId = productRepository.findByNameProduct(productRequest.getNameProduct());
                productDetail.setIdProduct(entity);
                productDetail.setIdProperty(property.get());
                productDetail.setQuantity(productRequest.getQuantity());
                productDetail.setIdProperty(property.get());
                productDetail.setIdSize(size.get());
                productDetailRepository.save(productDetail);
                return new DataObj().setEcode("200").setEdesc("Success");
            }
            DateTimeFormatter formatterCreate = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            ProductEntity product = productRepository.findByIdProduct(productRequest.getId());
            ProductDetailEntity productDetail = productDetailRepository.findByIdProduct(productRequest.getId());
            Optional<CategoryEntity> category;
            Optional<SizeEntity> size;
            Optional<PropertyEntity> property;
            Optional<ProductEntity> productId;
            ProductDetailEntity productDetailEntity = new ProductDetailEntity();
            if (productRequest.getImage() != null) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
                String formattedDate = LocalDateTime.now().format(formatter);
                String fileName = productRequest.getImage().getOriginalFilename();
                fileName = formattedDate + ".jpg";
                Files.copy(productRequest.getImage().getInputStream(), this.root.resolve(fileName));

                product.setImage("http://localhost:8080/image/get/" + fileName);
            }

            category = categoryRepository.findById(productRequest.getIdCategory());
            size = sizeRepository.findById(productRequest.getIdSize());
            property = propertyRepository.findById(productRequest.getIdProperties());
            // save danh sách product
            product.setPrice(productRequest.getPrice());
            product.setDiscount(productRequest.getDiscount());
            product.setStatus(productRequest.getStatus());
            product.setNameProduct(productRequest.getNameProduct());
            product.setDescription(productRequest.getDescription());
            product.setDescriptionDetail(productRequest.getDescriptionDetail());
            product.setCategoryEntity(category.get());
            product.setDate_create(LocalDate.now());
            ProductEntity entity = productRepository.save(product);
            productDetail.setIdProperty(property.get());
            productDetail.setQuantity(productRequest.getQuantity());
            productDetail.setIdProperty(property.get());
            productDetail.setIdSize(size.get());
            productDetailRepository.save(productDetail);
            return new DataObj().setEcode("200").setEdesc("Update Success");
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return  new DataObj().setEcode("400").setEdesc("Error").setData(e);
        }
    }

}
