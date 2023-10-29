package com.example.spring_boot.service;

import com.example.spring_boot.entity.OrderDetailEntity;
import com.example.spring_boot.payload.request.OderDetailRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.Optional;

public interface OderDetailService{

    Optional<OrderDetailEntity> findByID(Long id);

    Page<OrderDetailEntity> findAll(OderDetailRequest oderDetailRequest, PageRequest pageRequest);
}
