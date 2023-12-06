package com.example.spring_boot.service.impl;

import com.example.spring_boot.entity.*;
import com.example.spring_boot.payload.DataObj;
import com.example.spring_boot.payload.request.CreateProduct;
import com.example.spring_boot.payload.request.ProductRequest;
import com.example.spring_boot.repository.*;
import com.example.spring_boot.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

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
    public Page<Object[]> findAllProduct(ProductRequest productRequest) {
        try {
            Pageable pageable = PageRequest.of(
                    productRequest.getPage().intValue(),
                    productRequest.getSize().intValue()
            );

            return productRepository.findAllProduct(productRequest.getId(), productRequest.getNameProduct(), productRequest.getCategoryName(), pageable);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public DataObj findByIdProduct(Long idProduct) {
        try {
            Optional<ProductEntity> findId = productRepository.findById(idProduct);
            if (findId.isEmpty()) {
                return new DataObj().setEdesc("ID Product không tồn tại");
            }
            return new DataObj().setEdesc("Thành công").setData(productRepository.findProductById(idProduct));
        } catch (Exception ex) {
            ex.printStackTrace();
            return new DataObj().setEdesc("Lỗi");
        }
    }

    @Override
    public DataObj delete(Long idProduct) {
        try {
            ProductEntity productEntity = productRepository.findByIdProduct(idProduct);
            productEntity.setIsDelete(true);
//            ProductDetailEntity productDetailEntity = productDetailRepository.findByIdProduct(idProduct);
//            productDetailEntity.setIsDelete(true);
//            productDetailRepository.save(productDetailEntity);
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
    public DataObj save(CreateProduct createProduct) {

        try {
            if (createProduct.getId() == null) {
                DateTimeFormatter formatterCreate = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                ProductEntity product = new ProductEntity();
                ProductDetailEntity productDetail = new ProductDetailEntity();
                Optional<CategoryEntity> category;
                Optional<SizeEntity> size;
                Optional<PropertyEntity> property;
                Optional<ProductEntity> productId;
                ProductDetailEntity productDetailEntity = new ProductDetailEntity();
                if (createProduct.getImage() != null) {
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
                    String formattedDate = LocalDateTime.now().format(formatter);
                    String fileName = createProduct.getImage().getOriginalFilename();
                    fileName = formattedDate + ".jpg";
                    Files.copy(createProduct.getImage().getInputStream(), this.root.resolve(fileName));

                    product.setImage("http://localhost:8080/image/get/" + fileName);
                }

                category = categoryRepository.findById(createProduct.getIdCategory());
                size = sizeRepository.findById(createProduct.getIdSize());
                property = propertyRepository.findById(createProduct.getIdProperties());
                // save danh sách product
                long randomNumber = ThreadLocalRandom.current().nextLong(10000000L, 100000000L);
                product.setId(randomNumber);
                while (productRepository.existsById(product.getId())) {
                    product.setId(randomNumber);
                }
                product.setPrice(createProduct.getPrice());
//                product.setDiscount(createProduct.getDiscount());
                product.setStatus(createProduct.getStatus());
                product.setNameProduct(createProduct.getNameProduct());
                product.setDescription(createProduct.getDescription());
                product.setDescriptionDetail(createProduct.getDescriptionDetail());
                product.setCategoryEntity(category.get());
                product.setDate_create(LocalDate.now());
                ProductEntity entity = productRepository.save(product);
                //sai the nay ma bao dung a Kien
                productDetail.setIdProduct(entity);
                productDetail.setIdProperty(property.get());
                productDetail.setQuantity(createProduct.getQuantity());
                productDetail.setIdProperty(property.get());
                productDetail.setIdSize(size.get());
                productDetailRepository.save(productDetail);
                return new DataObj().setEcode("200").setEdesc("Success");
            }
            DateTimeFormatter formatterCreate = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            ProductEntity product = productRepository.findByIdProduct(createProduct.getId());
            ProductDetailEntity productDetail = productDetailRepository.findByIdProduct(createProduct.getId());
            Optional<CategoryEntity> category;
            Optional<SizeEntity> size;
            Optional<PropertyEntity> property;
            Optional<ProductEntity> productId;
            ProductDetailEntity productDetailEntity = new ProductDetailEntity();
            if (createProduct.getImage() != null) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
                String formattedDate = LocalDateTime.now().format(formatter);
                String fileName = createProduct.getImage().getOriginalFilename();
                fileName = formattedDate + ".jpg";
                Files.copy(createProduct.getImage().getInputStream(), this.root.resolve(fileName));

                product.setImage("http://localhost:8080/image/get/" + fileName);
            }

            category = categoryRepository.findById(createProduct.getIdCategory());
            size = sizeRepository.findById(createProduct.getIdSize());
            property = propertyRepository.findById(createProduct.getIdProperties());
            // save danh sách product
            product.setPrice(createProduct.getPrice());
//            product.setDiscount(createProduct.getDiscount());
            product.setStatus(createProduct.getStatus());
            product.setNameProduct(createProduct.getNameProduct());
            product.setDescription(createProduct.getDescription());
            product.setDescriptionDetail(createProduct.getDescriptionDetail());
            product.setCategoryEntity(category.get());
            product.setDate_create(LocalDate.now());
            ProductEntity entity = productRepository.save(product);
            productDetail.setIdProperty(property.get());
            productDetail.setQuantity(createProduct.getQuantity());
            productDetail.setIdProperty(property.get());
            productDetail.setIdSize(size.get());
            productDetailRepository.save(productDetail);
            return new DataObj().setEcode("200").setEdesc("Update Success");
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return new DataObj().setEcode("400").setEdesc("Error").setData(e);
        }
    }

    public DataObj findAllProductByName(String name) {
        try {
            return new DataObj().setEcode("200").setEdesc("Success").setData(productRepository.findProductsByName(name));

        } catch (Exception e) {
            e.printStackTrace();
            return new DataObj().setEcode("400").setEdesc("Error").setData(e);

        }
    }


}
