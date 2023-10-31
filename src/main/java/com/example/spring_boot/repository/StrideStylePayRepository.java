package com.example.spring_boot.repository;

import com.example.spring_boot.entity.StrideStylePayEntity;
import com.example.spring_boot.payload.request.StrideStylePayRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface StrideStylePayRepository extends JpaRepository<StrideStylePayEntity, Long> {
    @Query(value = "SELECT * FROM stride_style_pay WHERE is_delete = 0 ORDER BY id DESC",nativeQuery = true)
    Page<StrideStylePayEntity> findAllStrideStylePay(StrideStylePayRequest strideStylePayRequest, Pageable pageable);
}
