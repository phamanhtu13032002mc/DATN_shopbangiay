package com.example.spring_boot.security.service.impl;

import com.example.spring_boot.entity.Category;
import com.example.spring_boot.entity.Voucher;
import com.example.spring_boot.repository.VoucherRepository;
import com.example.spring_boot.security.service.VoucherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VoucherServieceImpl implements VoucherService {
    @Autowired
    VoucherRepository voucherRepository;

    @Override
    public List<Voucher> findAllDeleteIsFalse() {
        return voucherRepository.findAllByIsDeleteFalse();
    }

    @Override
    public Voucher save(Voucher voucher) {
        return voucherRepository.save(voucher);
    }

    @Override
    public void delete(long id) {
        Voucher voucher  = voucherRepository.findById(id).get();
        voucher.setIsDelete(true);
        voucherRepository.save(voucher);
    }

    @Override
    public Optional<Voucher> findByID(long id) {
        return voucherRepository.findById(id);
    }
}
