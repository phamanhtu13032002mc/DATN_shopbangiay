package com.example.spring_boot.controller.admin;

import com.example.spring_boot.payload.request.UrlVnpayRequest;
import com.example.spring_boot.service.VnPayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)

@RequestMapping("/vnpay")
public class VnpController {
    @Autowired
    VnPayService vnPayService;
    @PostMapping(value = "/url-vnpay")
    public String urlVnp(@RequestBody UrlVnpayRequest urlVnpayRequest) {
        return vnPayService.getUrlVnp(urlVnpayRequest);
    }
}
