package com.example.spring_boot.service.impl;

import com.example.spring_boot.entity.ProductEntity;
import com.example.spring_boot.payload.DataObj;
import com.example.spring_boot.payload.request.ProductRequest;
import com.example.spring_boot.repository.ProductRepository;
import com.example.spring_boot.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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
    public Page<Object[]> findAllProduct(ProductRequest productRequest) {
        try {
            Pageable pageable = PageRequest.of(
                    productRequest.getPage().intValue(),
                    productRequest.getSize().intValue()
            );
            return productRepository.findAllProduct(productRequest, pageable);
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
    public void delete(Long id) {
        ProductEntity productEntity = productRepository.findById(id).get();
        productEntity.setIsDelete(true);
        productRepository.save(productEntity);

    }

    @Override
    public ProductEntity create(ProductEntity productEntity) {
        return productRepository.save(productEntity);
    }




}
