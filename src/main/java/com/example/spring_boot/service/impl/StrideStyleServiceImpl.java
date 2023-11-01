package com.example.spring_boot.service.impl;

import com.example.spring_boot.entity.StrideStylePayEntity;
import com.example.spring_boot.payload.request.PropertiesRequest;
import com.example.spring_boot.payload.request.StrideStylePayRequest;
import com.example.spring_boot.repository.StrideStylePayRepository;
import com.example.spring_boot.service.StrideStylePayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class StrideStyleServiceImpl implements StrideStylePayService {
    @Autowired
    StrideStylePayRepository strideStylePayRepository;
    @Override
    public Page<StrideStylePayEntity> findAllStryStylePay(StrideStylePayRequest strideStylePayRequest) {
        Pageable pageable = PageRequest.of(Math.toIntExact(strideStylePayRequest.getPage()), Math.toIntExact(strideStylePayRequest.getSize()));
        return strideStylePayRepository.findAllStrideStylePay(strideStylePayRequest, pageable);
    }
}
