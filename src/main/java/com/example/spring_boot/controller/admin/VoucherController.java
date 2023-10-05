package com.example.spring_boot.controller.admin;

import com.example.spring_boot.entity.Voucher;
import com.example.spring_boot.security.service.VoucherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/VoucherManager")
public class VoucherController {
    @Autowired
    VoucherService voucherService;
    @GetMapping(value = "/findAllByIsDeleteFalse")
    public ResponseEntity<?> getVoucherList() {
        return new  ResponseEntity(voucherService.findAllDeleteIsFalse(), HttpStatus.OK);
    }
    @PostMapping(value = "VoucherSave")
    public ResponseEntity<?> SaveVoucher(@RequestBody Voucher voucher) {
        return new  ResponseEntity(voucherService.save(voucher), HttpStatus.OK);
    }
    @PostMapping(value = "VoucherUpdate")
    public ResponseEntity<?> UpdateVoucher(@RequestBody Voucher voucher) {
        return new  ResponseEntity(voucherService.save(voucher), HttpStatus.OK);
    }
    @GetMapping(value = "VoucherDelete/{id}")
    public ResponseEntity<?> DeleteVoucher(@PathVariable("id") long id) {
        voucherService.delete(id);
        return new  ResponseEntity("successfully", HttpStatus.OK);
    }
    @GetMapping(value = "FindVoucher/{id}")
    public ResponseEntity<?> getVoucherById(@PathVariable("id") long id) {

        return new  ResponseEntity(voucherService.findByID(id), HttpStatus.OK);
    }
}
