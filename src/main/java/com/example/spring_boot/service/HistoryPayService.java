package com.example.spring_boot.service;

import com.example.spring_boot.entity.CategoryEntity;
import com.example.spring_boot.entity.HistoryPayEntity;
import com.example.spring_boot.payload.request.HistoryPayRequest;
import com.example.spring_boot.payload.request.ProductRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.Optional;

public interface HistoryPayService {

    Optional<HistoryPayEntity> findByID(Long id);


    Page<HistoryPayEntity> findAllHistoryPay(HistoryPayRequest historyPayRequest);


}
