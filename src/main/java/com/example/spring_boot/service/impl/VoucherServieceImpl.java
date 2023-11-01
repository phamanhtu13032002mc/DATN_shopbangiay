package com.example.spring_boot.service.impl;

import com.example.spring_boot.entity.EventEntity;
import com.example.spring_boot.entity.VoucherEntity;
import com.example.spring_boot.payload.request.VoucherRequest;
import com.example.spring_boot.repository.VoucherRepository;
import com.example.spring_boot.service.VoucherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class VoucherServieceImpl implements VoucherService {
    @Autowired
    VoucherRepository voucherRepository;

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

    @Override
    public Page<VoucherEntity> findAllVoucher(VoucherRequest voucherRequest) {
        Pageable pageable = PageRequest.of(Math.toIntExact(voucherRequest.getPage()), Math.toIntExact(voucherRequest.getSize()));
        return voucherRepository.findAllHistoryPay(voucherRequest, pageable);
    }

    @Override
    public VoucherEntity create(VoucherRequest voucherRequest) {
        try {
            VoucherEntity voucher = new VoucherEntity();
            voucher.setName(voucherRequest.getName());
            voucher.setAmount(voucherRequest.getAmount());
            voucher.setDiscount(voucherRequest.getDiscount());
            voucher.setMinimumValue(voucherRequest.getMinimumValue());
            voucher.setIdEvent(voucherRequest.getIdEvent());
            return voucherRepository.save(voucher);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Lỗi xử lý Voucher");
        }
    }

    @Override
    public VoucherEntity detele(Long id) {
        try {
            VoucherEntity event = voucherRepository.findById(id).orElseThrow(() -> {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Không tìm thấy sự kiện");
            });
            event.setIsDelete(true);
            return voucherRepository.save(event);
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Lỗi xóa");
        }
    }

    @Override
    public VoucherEntity update(Long id, VoucherRequest voucherRequest) {
        try {
            VoucherEntity voucher = voucherRepository.findById(id).orElseThrow(() -> {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Không tìm thấy sự kiện");
            });
            voucher.setName(voucherRequest.getName());
            voucher.setAmount(voucherRequest.getAmount());
            voucher.setDiscount(voucherRequest.getDiscount());
            voucher.setMinimumValue(voucherRequest.getMinimumValue());
            voucher.setIdEvent(voucherRequest.getIdEvent());
            return voucherRepository.save(voucher);
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Lỗi update");
        }
    }

}
