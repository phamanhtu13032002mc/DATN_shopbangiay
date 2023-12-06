package com.example.spring_boot.service.impl;

import com.example.spring_boot.entity.ProductDetailEntity;
import com.example.spring_boot.payload.DataObj;
import com.example.spring_boot.payload.request.ProductDetailRequest;
import com.example.spring_boot.repository.ProductDetailRepository;
import com.example.spring_boot.service.ProductDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductDetailServiceImpl implements ProductDetailService {
    @Autowired
    ProductDetailRepository productDetailRepository;

    @Override
    public void delete(Long id) {
        ProductDetailEntity productDetail = productDetailRepository.findById(id).get();
        productDetail.setIsDelete(true);
        productDetailRepository.save(productDetail);
    }

    @Override
    public DataObj findProductDetailByProduct(ProductDetailRequest productDetailRequest) {
        try {
            Pageable pageable = PageRequest.of(
                    productDetailRequest.getPage().intValue(),
                    productDetailRequest.getSize().intValue()
            );
            Page<Object> listProduct = productDetailRepository.findProductDetailByProduct(productDetailRequest.getProductId(),pageable);
            return new DataObj().setEdesc("Find success").setData(listProduct);
        } catch (Exception e) {
            e.printStackTrace();
            return new DataObj().setEdesc("Find fail");
        }
    }
}
