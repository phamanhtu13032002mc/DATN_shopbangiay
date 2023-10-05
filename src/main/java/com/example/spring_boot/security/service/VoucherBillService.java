package com.example.spring_boot.security.service;

import com.example.spring_boot.entity.Voucher;
import com.example.spring_boot.entity.VoucherBill;

import java.util.List;

public interface VoucherBillService {
    List<VoucherBill> findAllDeleteIsFalse();

    VoucherBill save(VoucherBill voucherBill);


}
