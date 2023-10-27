package com.example.spring_boot.service;

import com.example.spring_boot.entity.CategoryEntity;
import com.example.spring_boot.entity.HistoryPayEntity;
import com.example.spring_boot.payload.request.HistoryPayRequest;

import java.util.List;
import java.util.Optional;

public interface HistoryPayService {
    List<HistoryPayEntity> findAll(HistoryPayRequest historyPayRequest);

    Optional<HistoryPayEntity> findByID(Long id);
}
