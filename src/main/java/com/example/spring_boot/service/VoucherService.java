package com.example.spring_boot.service;
import com.example.spring_boot.entity.VoucherEntity;
import com.example.spring_boot.payload.DataObj;
import com.example.spring_boot.payload.request.CheckVoucherRequest;
import com.example.spring_boot.payload.request.VoucherRequest;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface VoucherService {

    void delete(long id);

    Optional<VoucherEntity> findByID(long id);



    Page<VoucherEntity> findAllVoucher(VoucherRequest voucherRequest);


    Object create(VoucherRequest voucherRequest);

    Object detele(VoucherRequest voucherRequest);

    Object update(VoucherRequest voucherRequest);

    Object findByNameLike(VoucherRequest voucherRequest);

    DataObj checkVoucher(CheckVoucherRequest voucherRequest);
}
