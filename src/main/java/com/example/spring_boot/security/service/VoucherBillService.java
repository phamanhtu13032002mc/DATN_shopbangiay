package com.example.spring_boot.security.service;

import com.example.spring_boot.entity.VoucherBillEntity;

import java.util.List;

public interface VoucherBillService {
    List<VoucherBillEntity> findAllDeleteIsFalse();

    VoucherBillEntity save(VoucherBillEntity voucherBillEntity);


}
