package com.example.spring_boot.service.impl;

import com.example.spring_boot.entity.*;
import com.example.spring_boot.payload.DataObj;
import com.example.spring_boot.payload.request.CheckVoucherRequest;
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

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
            VoucherEntity voucher = new VoucherEntity();

            EventEntity eventEntity =  voucherRepository.findByIdEven(voucherRequest.getIdEvent());
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
            String formattedDate = LocalDateTime.now().format(formatter);
            Long idVoucher = Long.parseLong(formattedDate);
                voucher.setId(idVoucher);
                voucher.setName(voucherRequest.getName());
                voucher.setAmount(voucherRequest.getAmount());
                voucher.setDiscount(voucherRequest.getDiscount());
                voucher.setMinimumValue(voucherRequest.getMinimumValue());
                voucher.setEventEntity(eventEntity);

                return new DataObj().setEcode("200").setEdesc("Create Complete").setData(voucherRepository.save(voucher));


        }catch (Exception e){
            e.printStackTrace();
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

    @Override
    public DataObj checkVoucher(CheckVoucherRequest voucherRequest) {
        try {
            LocalDate currentDate = LocalDate.now();
            VoucherEntity voucherEntity = voucherRepository.findByIdVoucher(voucherRequest.getId());
            if (voucherEntity == null) {
                return new DataObj().setEdesc("420").setEdesc("Không tìm thấy voucher");
            }
            if (voucherRequest.getTotal() <  voucherEntity.getMinimumValue()) {
                return new DataObj().setEdesc("420").setEdesc("Hóa Đơn Nhỏ Hơn giá trị yêu cầu của voucher không thể ap dụng Voucher");
            }
            if (voucherEntity.getAmount() <= 0) {
                return new DataObj().setEdesc("420").setEdesc("số lượng voucher đã hết");

            }
            if (voucherEntity.getEventEntity().getEndDay().isBefore(currentDate)) {
                return new DataObj().setEdesc("420").setEdesc("voucher đã hết hạn");

            }
            if (voucherEntity.getEventEntity().getStartDay().isAfter(currentDate)) {
                return new DataObj().setEdesc("420").setEdesc("voucher Chưa bắt đầu");
            }
            return new DataObj(voucherEntity).setEdesc("200").setEdesc("Thành Công");

        }catch (Exception e)
        {
            e.printStackTrace();
            return new DataObj().setEdesc("400").setEdesc("lỗi");

        }
    }


}
