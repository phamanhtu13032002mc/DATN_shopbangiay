package com.example.spring_boot.service;

import com.example.spring_boot.entity.StrideStylePayEntity;
import com.example.spring_boot.payload.request.PropertiesRequest;
import com.example.spring_boot.payload.request.StrideStylePayRequest;
import org.springframework.data.domain.Page;

public interface StrideStylePayService {

    Page<StrideStylePayEntity> findAllStryStylePay(StrideStylePayRequest strideStylePayRequest);
}
