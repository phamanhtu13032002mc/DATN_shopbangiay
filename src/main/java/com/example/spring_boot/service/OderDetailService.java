package com.example.spring_boot.service;

import com.example.spring_boot.entity.OderDetailEntity;
import com.example.spring_boot.payload.request.OderDetailRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.Optional;

public interface OderDetailService{

    Optional<OderDetailEntity> findByID(Long id);

    Page<OderDetailEntity> findAll(OderDetailRequest oderDetailRequest, PageRequest pageRequest);
}
