package com.example.spring_boot.service;

import com.example.spring_boot.entity.BillEntity;
import com.example.spring_boot.entity.CategoryEntity;
import com.example.spring_boot.payload.request.BillRequest;
import com.example.spring_boot.payload.request.CategoryRequest;

import java.util.List;

public interface BillService {
    List<BillEntity> findAll(BillRequest billRequest);
}
