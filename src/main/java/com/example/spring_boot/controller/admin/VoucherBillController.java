package com.example.spring_boot.controller.admin;

import com.example.spring_boot.entity.VoucherBillEntity;
import com.example.spring_boot.service.VoucherBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/voucher-bill-manager")
public class VoucherBillController {
    @Autowired
    VoucherBillService voucherBillService;

    @GetMapping(value = "/find-all")
    public ResponseEntity<?> getVoucherBillList() {
        return new  ResponseEntity(voucherBillService.findAllDeleteIsFalse(), HttpStatus.OK);
    }



}
