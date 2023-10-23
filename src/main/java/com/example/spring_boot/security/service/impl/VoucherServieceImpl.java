package com.example.spring_boot.security.service.impl;

import com.example.spring_boot.entity.VoucherEntity;
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
    public List<VoucherEntity> findAllDeleteIsFalse() {
        return voucherRepository.findAllByIsDeleteFalse();
    }

    @Override
    public VoucherEntity save(VoucherEntity voucherEntity) {
        return voucherRepository.save(voucherEntity);
    }

    @Override
    public void delete(long id) {
        VoucherEntity voucherEntity = voucherRepository.findById(id).get();
        voucherEntity.setIsDelete(true);
        voucherRepository.save(voucherEntity);
    }

    @Override
    public Optional<VoucherEntity> findByID(long id) {
        return voucherRepository.findById(id);
    }
}
