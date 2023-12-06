package com.example.spring_boot.controller.admin;

import com.example.spring_boot.entity.OrderDetailEntity;
import com.example.spring_boot.payload.request.OrderDetailRequest;
import com.example.spring_boot.payload.request.ProductRequest;
import com.example.spring_boot.payload.request.VoucherRequest;
import com.example.spring_boot.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)

@RequestMapping("/oder-detail-manager")
public class OderDetailController {
    @Autowired
    OrderDetailService orderDetailService;
    @PostMapping("/delete")
    public ResponseEntity<?> delete(@RequestBody OrderDetailRequest orderDetailRequest) {

        return ResponseEntity.ok(orderDetailService.detele(orderDetailRequest));

    }
}
