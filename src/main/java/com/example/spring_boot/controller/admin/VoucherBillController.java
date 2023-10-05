package com.example.spring_boot.controller.admin;

import com.example.spring_boot.entity.Voucher;
import com.example.spring_boot.entity.VoucherBill;
import com.example.spring_boot.security.service.VoucherBillService;
import com.example.spring_boot.security.service.VoucherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/VoucherBillManager")
public class VoucherBillController {
    @Autowired
    VoucherBillService voucherBillService;

    @GetMapping(value = "/findAllByIsDeleteFalse")
    public ResponseEntity<?> getVoucherBillList() {
        return new  ResponseEntity(voucherBillService.findAllDeleteIsFalse(), HttpStatus.OK);
    }
    @PostMapping(value = "VoucherBillSave")
    public ResponseEntity<?> SaveVoucherBill(@RequestBody VoucherBill voucherBill) {
        return new  ResponseEntity(voucherBillService.save(voucherBill), HttpStatus.OK);
    }
    @PostMapping(value = "VoucherBillUpdate")
    public ResponseEntity<?> UpdateVoucherBill(@RequestBody VoucherBill voucherBill) {
        return new  ResponseEntity(voucherBillService.save(voucherBill), HttpStatus.OK);
    }


}
