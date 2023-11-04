package com.example.spring_boot.service.impl;

import com.example.spring_boot.entity.BillEntity;
import com.example.spring_boot.entity.ProductEntity;
import com.example.spring_boot.payload.request.BillRequest;
import com.example.spring_boot.repository.BillRepository;
import com.example.spring_boot.service.BillService;
import com.example.spring_boot.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillServiceImpl implements BillService {
    @Autowired
    BillRepository billRepository;


    @Override
    public Page<BillEntity> findAllBill(BillRequest billRequest) {
        Pageable pageable = PageRequest.of(Math.toIntExact(billRequest.getPage()), Math.toIntExact(billRequest.getSize()));
        return billRepository.findAllBill(billRequest, pageable);
    }
}
