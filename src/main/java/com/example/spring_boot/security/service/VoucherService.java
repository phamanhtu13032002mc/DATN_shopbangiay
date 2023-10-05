package com.example.spring_boot.security.service;
import com.example.spring_boot.entity.Voucher;

import java.util.List;
import java.util.Optional;

public interface VoucherService {
    List<Voucher> findAllDeleteIsFalse();

    Voucher save(Voucher voucher);

    void delete(long id);

    Optional<Voucher> findByID(long id);
}
