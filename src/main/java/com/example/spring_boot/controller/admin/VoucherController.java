package com.example.spring_boot.controller.admin;

import com.example.spring_boot.entity.VoucherEntity;
import com.example.spring_boot.payload.request.EventRequest;
import com.example.spring_boot.payload.request.VoucherRequest;
import com.example.spring_boot.service.VoucherService;
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
    public ResponseEntity<?> getVoucherList(VoucherRequest voucherRequest) {
        return new ResponseEntity(voucherService.findAll(voucherRequest), HttpStatus.OK);
    }

}
