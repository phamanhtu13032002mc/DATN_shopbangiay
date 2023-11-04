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
    @Autowired
    BillRepository billRepository;
    @Autowired
    ProductDetailRepository productDetailRepository;

    @Override
    public Optional<OrderDetailEntity> findByID(Long id) {
        return oderDetailRepository.findById(id);
    }

    @Override
    public Page<OrderDetailEntity> findAllOderDetail(OrderDetailRequest oderDetailRequest) {
        Pageable pageable = PageRequest.of(Math.toIntExact(oderDetailRequest.getPage()), Math.toIntExact(oderDetailRequest.getSize()));
        return oderDetailRepository.findAllOderDetail(oderDetailRequest, pageable);
    }

    @Override
    public Object create(OrderDetailRequest oderDetailRequest) {
        try {
            OrderDetailEntity orderDetail = new OrderDetailEntity();
            orderDetail.setPrice(oderDetailRequest.getPrice());
            orderDetail.setDownPrice(oderDetailRequest.getDownPrice());
            orderDetail.setIntoMoney(oderDetailRequest.getIntoMoney());
            orderDetail.setQuantity_oder(oderDetailRequest.getQuantity_oder());
            Optional<BillEntity> bill;
            bill = billRepository.findById(oderDetailRequest.getId_bill());
            orderDetail.setBillEntity(bill.get());
            OrderDetailEntity savedOrderDetail = oderDetailRepository.save(orderDetail);
            return new DataObj().setEcode("200").setEdesc("Create Complete").setData(savedOrderDetail);
        } catch (Exception e) {
            return new DataObj().setEdesc("Lỗi .");
        }
    }

    @Override
    public Object detele(OrderDetailRequest orderDetailRequest) {

        try {
            Optional<OrderDetailEntity> detailEntityOptional = oderDetailRepository.findById(orderDetailRequest.getId());
            if (detailEntityOptional.isEmpty()) {
                return new DataObj().setEcode("505").setEdesc("ID does not exit !");
            } else {
                OrderDetailEntity orderDetail = detailEntityOptional.get();
                orderDetail.setIsDelete(true);
                return new DataObj().setEcode("200").setEdesc("DELETE Complete").setData(oderDetailRepository.save(orderDetail));
            }
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Lỗi xóa");
        }
    }

    @Override
    public Object update(OrderDetailRequest orderDetailRequest) {

        try {
            Optional<OrderDetailEntity> optionalOrderDetail = oderDetailRepository.findById(orderDetailRequest.getId());
            if (optionalOrderDetail.isPresent()) {
                OrderDetailEntity orderDetail = optionalOrderDetail.get();
                orderDetail.setPrice(orderDetailRequest.getPrice());
                orderDetail.setDownPrice(orderDetailRequest.getDownPrice());
                orderDetail.setIntoMoney(orderDetailRequest.getIntoMoney());
                orderDetail.setQuantity_oder(orderDetailRequest.getQuantity_oder());
                Optional<BillEntity> bill;
                bill = billRepository.findById(orderDetailRequest.getId_bill());
                orderDetail.setBillEntity(bill.get());
                return new DataObj().setEcode("200").setEdesc("Success").setData(oderDetailRepository.save(orderDetail));
            } else {
                return new DataObj().setEcode("505").setEdesc("ID does not exit !");
            }
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Lỗi update");
        }
    }


}
