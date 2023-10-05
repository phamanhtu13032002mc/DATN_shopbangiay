package com.example.spring_boot.security.service.impl;

import com.example.spring_boot.entity.Voucher;
import com.example.spring_boot.entity.VoucherBill;
import com.example.spring_boot.repository.VoucherBillRespository;
import com.example.spring_boot.security.service.VoucherBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class VoucherBillServiceImpl implements VoucherBillService {
    @Autowired
    VoucherBillRespository voucherBillRespository;
    @Override
    public List<VoucherBill> findAllDeleteIsFalse() {
        return voucherBillRespository.findAllByIsDeleteFalse();
    }

    @Override
    public VoucherBill save(VoucherBill voucherBill) {
        return voucherBillRespository.save(voucherBill);
    }

  


}

