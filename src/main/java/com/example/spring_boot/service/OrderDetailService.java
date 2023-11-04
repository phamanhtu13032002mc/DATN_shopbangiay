package com.example.spring_boot.service;

import com.example.spring_boot.entity.OrderDetailEntity;
import com.example.spring_boot.payload.request.OrderDetailRequest;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface OrderDetailService {

    Optional<OrderDetailEntity> findByID(Long id);



    Page<OrderDetailEntity> findAllOderDetail(OrderDetailRequest oderDetailRequest);

    Object create(OrderDetailRequest oderDetailRequest);

    Object detele(OrderDetailRequest orderDetailRequest);

    Object update(OrderDetailRequest orderDetailRequest);
}
