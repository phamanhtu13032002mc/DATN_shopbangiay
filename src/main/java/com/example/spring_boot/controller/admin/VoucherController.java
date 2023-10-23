package com.example.spring_boot.controller.admin;

import com.example.spring_boot.entity.VoucherEntity;
import com.example.spring_boot.security.service.VoucherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/voucher-manager")
public class VoucherController {
    @Autowired
    VoucherService voucherService;
    @GetMapping(value = "/find-all")
    public ResponseEntity<?> getVoucherList() {
        return new  ResponseEntity(voucherService.findAllDeleteIsFalse(), HttpStatus.OK);
    }
    @PostMapping(value = "/save")
    public ResponseEntity<?> saveVoucher(@RequestBody VoucherEntity voucherEntity) {
        return new  ResponseEntity(voucherService.save(voucherEntity), HttpStatus.OK);
    }
    @PostMapping(value = "update")
    public ResponseEntity<?> updateVoucher(@RequestBody VoucherEntity voucherEntity) {
        return new  ResponseEntity(voucherService.save(voucherEntity), HttpStatus.OK);
    }
    @GetMapping(value = "/delete/{id}")
    public ResponseEntity<?> deleteVoucher(@PathVariable("id") long id) {
        voucherService.delete(id);
        return new  ResponseEntity("successfully", HttpStatus.OK);
    }
    @GetMapping(value = "/get-by-id/{id}")
    public ResponseEntity<?> getVoucherById(@PathVariable("id") long id) {

        return new  ResponseEntity(voucherService.findByID(id), HttpStatus.OK);
    }
}
