package com.example.spring_boot.service.impl;

import com.example.spring_boot.entity.*;
import com.example.spring_boot.payload.DataObj;
import com.example.spring_boot.payload.request.OrderDetailRequest;
import com.example.spring_boot.repository.BillRepository;
import com.example.spring_boot.repository.OrderDetailRepository;
import com.example.spring_boot.repository.ProductDetailRepository;
import com.example.spring_boot.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {
    @Autowired
    OrderDetailRepository oderDetailRepository;
    @Override
    public Object detele(OrderDetailRequest orderDetailRequest) {

        try {
            Optional<OrderDetailEntity> detailEntityOptional = oderDetailRepository.findById(orderDetailRequest.getProductId());
            if (detailEntityOptional.isEmpty()) {
                return new DataObj().setEcode("505").setEdesc("ID does not exit !");
            } else {
                OrderDetailEntity orderDetail = detailEntityOptional.get();
                oderDetailRepository.delete(orderDetail);
                return new DataObj().setEcode("200").setEdesc("DELETE Complete");
            }
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Lỗi xóa");
        }
    }
    @Override
    public Page<OrderDetailEntity> findByIdBill(OrderDetailRequest orderDetailRequest) {

        try {
            Pageable pageable = PageRequest.of(
                    orderDetailRequest.getPage().intValue(),
                    orderDetailRequest.getSize().intValue()
            );
            return oderDetailRepository.findByIdBill(orderDetailRequest.getIdBill(), pageable);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
