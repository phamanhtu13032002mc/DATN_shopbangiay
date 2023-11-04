package com.example.spring_boot.repository;

import com.example.spring_boot.entity.OrderDetailEntity;
import com.example.spring_boot.payload.request.OrderDetailRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OrderDetailRepository extends JpaRepository<OrderDetailEntity,Long> {
    @Query(value = "SELECT * FROM orderdetail WHERE is_delete = 0 ORDER BY id DESC",nativeQuery = true)
    Page<OrderDetailEntity> findAllOderDetail(OrderDetailRequest oderDetailRequest, Pageable pageable);
}
