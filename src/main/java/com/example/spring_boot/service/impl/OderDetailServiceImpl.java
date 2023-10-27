package com.example.spring_boot.service.impl;

import com.example.spring_boot.entity.OderDetailEntity;
import com.example.spring_boot.payload.request.OderDetailRequest;
import com.example.spring_boot.repository.OderDetailRepository;
import com.example.spring_boot.service.OderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OderDetailServiceImpl implements OderDetailService {
    @Autowired
    OderDetailRepository oderDetailRepository;

    @Override
    public List<OderDetailEntity> findAll(OderDetailRequest oderDetailRequest) {
        return oderDetailRepository.findAll();
    }

    @Override
    public Optional<OderDetailEntity> findByID(Long id) {
        return oderDetailRepository.findById(id);
    }
}
