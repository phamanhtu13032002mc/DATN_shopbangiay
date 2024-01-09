package com.example.spring_boot.repository;

import com.example.spring_boot.entity.CustomerEntity;
import com.example.spring_boot.entity.VoucherEntity;
import com.example.spring_boot.payload.request.VoucherRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VoucherRepository extends JpaRepository<VoucherEntity,Long> {



    @Query(value = "SELECT * FROM voucher WHERE is_delete = 0 ORDER BY id DESC",nativeQuery = true)
    Page<VoucherEntity> findAllHistoryPay(VoucherRequest voucherRequest, Pageable pageable);
    @Query("SELECT V FROM VoucherEntity V WHERE :name IS NULL OR V.name LIKE %:name%")
    Page<VoucherEntity> findByNameLike(String name, Pageable pageable);

    @Query(value = "SELECT * FROM voucher vc WHERE vc.id = ?",nativeQuery = true)
    VoucherEntity findByIdVoucher(Long id);
}
