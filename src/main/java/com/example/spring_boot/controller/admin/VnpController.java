package com.example.spring_boot.controller.admin;

import com.example.spring_boot.payload.request.UrlVnpayRequest;
import com.example.spring_boot.service.VnPayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)

@RequestMapping("/vnpay")
public class VnpController {
    @Autowired
    VnPayService vnPayService;
    @PostMapping(value = "/url-vnpay")
    public ResponseEntity<?> urlVnp(@RequestBody UrlVnpayRequest urlVnpayRequest) {
        return ResponseEntity.ok(vnPayService.getUrlVnp(urlVnpayRequest));
    }
    @GetMapping(value = "/url-return")
    public ResponseEntity<?> urlReturn( HttpServletRequest request) {
        return ResponseEntity.ok(vnPayService.ReturnURL(request));
    }

}
