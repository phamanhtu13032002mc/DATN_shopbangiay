package com.example.spring_boot.service;
import com.example.spring_boot.entity.VoucherEntity;
import com.example.spring_boot.payload.request.VoucherRequest;

import java.util.List;
import java.util.Optional;

public interface VoucherService {
    List<VoucherEntity> findAllDeleteIsFalse();

    VoucherEntity save(VoucherEntity voucherEntity);

    void delete(long id);

    Optional<VoucherEntity> findByID(long id);

    List<VoucherEntity> findAll(VoucherRequest voucherRequest);
}
