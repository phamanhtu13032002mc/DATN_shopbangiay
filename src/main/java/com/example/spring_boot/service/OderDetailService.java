package com.example.spring_boot.service;

import com.example.spring_boot.entity.OrderDetailEntity;
import com.example.spring_boot.payload.request.OderDetailRequest;

import java.util.List;
import java.util.Optional;

public interface OderDetailService{

    List<OrderDetailEntity> findAll(OderDetailRequest oderDetailRequest);

    Optional<OrderDetailEntity> findByID(Long id);
}
