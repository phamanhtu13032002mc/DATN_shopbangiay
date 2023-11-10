package com.example.spring_boot.service.impl;

import com.example.spring_boot.entity.CategoryEntity;
import com.example.spring_boot.entity.EventEntity;
import com.example.spring_boot.entity.VoucherEntity;
import com.example.spring_boot.payload.DataObj;
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
    public Object create(VoucherRequest voucherRequest) {
        try {
            if (voucherRequest.getName() == null){
                return new DataObj().setEdesc("Name  not null !!!");
            }
            if (voucherRequest.getAmount() == null){
                return new DataObj().setEdesc("amount not null !!!");
            }
            if (voucherRequest.getDiscount() == null){
                return new DataObj().setEdesc("Discount not null !!!");
            }
            if (voucherRequest.getMinimumValue() == null){
                return new DataObj().setEdesc("Minimum Value not null !!!");
            }
            if (voucherRequest.getIdEvent() == null){
                return new DataObj().setEdesc("id_event Value not null !!!");
            }
            else {
                VoucherEntity voucher = new VoucherEntity();
                voucher.setName(voucherRequest.getName());
                voucher.setAmount(voucherRequest.getAmount());
                voucher.setDiscount(voucherRequest.getDiscount());
                voucher.setMinimumValue(voucherRequest.getMinimumValue());
                voucher.setIdEvent(voucherRequest.getIdEvent());

                return new DataObj().setEcode("200").setEdesc("Create Complete").setData(voucherRepository.save(voucher));

            }
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Lỗi Voucher");
        }
    }

    @Override
    public Object detele(VoucherRequest voucherRequest) {
        try {
            Optional<VoucherEntity> voucherOptional = voucherRepository.findById(voucherRequest.getId());
            if (voucherOptional.isEmpty()) {
                return new DataObj().setEcode("505").setEdesc("ID does not exit !");
            } else {
                VoucherEntity voucher = voucherOptional.get();
                voucher.setIsDelete(true);
                return new DataObj().setEcode("200").setEdesc("DELETE Complete").setData(voucherRepository.save(voucher));
            }
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Lỗi xóa");
        }
    }

    @Override
    public Object update(VoucherRequest voucherRequest) {
        try {
            Optional<VoucherEntity> optionalVoucher = voucherRepository.findById(voucherRequest.getId());
            if (optionalVoucher.isPresent()) {
                VoucherEntity voucher = optionalVoucher.get();
                voucher.setName(voucherRequest.getName());
                voucher.setAmount(voucherRequest.getAmount());
                voucher.setDiscount(voucherRequest.getDiscount());
                voucher.setMinimumValue(voucherRequest.getMinimumValue());
                voucher.setIdEvent(voucherRequest.getIdEvent());
                return new DataObj().setEcode("200").setEdesc("Success").setData(voucherRepository.save(voucher));
            } else {
                return new DataObj().setEcode("505").setEdesc("ID does not exit !");
            }
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Lỗi update");
        }
    }

    @Override
    public Object findByNameLike(VoucherRequest voucherRequest) {
        Pageable pageable = PageRequest.of(Math.toIntExact(voucherRequest.getPage()), Math.toIntExact(voucherRequest.getSize()));
        Page<VoucherEntity> voucherEntities = voucherRepository.findByNameLike(voucherRequest.getName(), pageable);

        DataObj dataObj = new DataObj();
        dataObj.setEcode("200");
        dataObj.setEdesc("success");
        dataObj.setData(voucherEntities.getContent());

        return dataObj;
    }


}
