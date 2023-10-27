package com.example.spring_boot.service.impl;

import com.example.spring_boot.entity.HistoryPayEntity;
import com.example.spring_boot.payload.request.HistoryPayRequest;
import com.example.spring_boot.repository.HistoryPayRepository;
import com.example.spring_boot.service.HistoryPayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HistoryPayServiceImpl implements HistoryPayService {
    @Autowired
    HistoryPayRepository historyPayRespository;
    @Override
    public List<HistoryPayEntity> findAll(HistoryPayRequest historyPayRequest) {
        return historyPayRespository.findAll();
    }

    @Override
    public Optional<HistoryPayEntity> findByID(Long id) {
        return historyPayRespository.findById(id);
    }
}
