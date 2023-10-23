package com.example.spring_boot.security.service;
import com.example.spring_boot.entity.VoucherEntity;

import java.util.List;
import java.util.Optional;

public interface VoucherService {
    List<VoucherEntity> findAllDeleteIsFalse();

    VoucherEntity save(VoucherEntity voucherEntity);

    void delete(long id);

    Optional<VoucherEntity> findByID(long id);
}
