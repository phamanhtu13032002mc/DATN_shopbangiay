package com.example.spring_boot.service.impl;

import com.example.spring_boot.entity.VoucherBillEntity;
import com.example.spring_boot.repository.VoucherBillRespository;
import com.example.spring_boot.service.VoucherBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class VoucherBillServiceImpl implements VoucherBillService {
    @Autowired
    VoucherBillRespository voucherBillRespository;
    @Override
    public List<VoucherBillEntity> findAllDeleteIsFalse() {
        return voucherBillRespository.findAllByIsDeleteFalse();
    }

    @Override
    public VoucherBillEntity save(VoucherBillEntity voucherBillEntity) {
        return voucherBillRespository.save(voucherBillEntity);
    }

  


}

