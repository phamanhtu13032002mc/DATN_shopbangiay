package com.example.spring_boot.service;

import com.example.spring_boot.entity.OderDetailEntity;
import com.example.spring_boot.payload.request.OderDetailRequest;

import java.util.List;
import java.util.Optional;

public interface OderDetailService{

    List<OderDetailEntity> findAll(OderDetailRequest oderDetailRequest);

    Optional<OderDetailEntity> findByID(Long id);
}
