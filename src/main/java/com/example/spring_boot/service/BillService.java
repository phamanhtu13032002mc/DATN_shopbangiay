package com.example.spring_boot.service;

import com.example.spring_boot.entity.BillEntity;
import com.example.spring_boot.entity.CategoryEntity;
import com.example.spring_boot.entity.ProductEntity;
import com.example.spring_boot.payload.request.BillRequest;
import com.example.spring_boot.payload.request.CategoryRequest;
import com.example.spring_boot.payload.request.ProductRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface BillService {

    Page<BillEntity> findAll(BillRequest billRequest, PageRequest pageRequest);
}
