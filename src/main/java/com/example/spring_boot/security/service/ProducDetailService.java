package com.example.spring_boot.security.service;

import com.example.spring_boot.entity.Productdetail;
import com.example.spring_boot.payload.request.CreateProductDetail;

import java.util.List;

public interface ProducDetailService {

    List<Productdetail> findAll();

    List<Productdetail> findAllByIsDeleteFalse();


    List<Productdetail> create(CreateProductDetail createProductDetail);
    void delete(Long id);


}
