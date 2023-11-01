package com.example.spring_boot.controller.admin;
import com.example.spring_boot.payload.request.PropertiesRequest;
import com.example.spring_boot.payload.request.StrideStylePayRequest;
import com.example.spring_boot.service.StrideStylePayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)

@RequestMapping("/stride-style-pay-manager")
public class StrideStylePayController {
    @Autowired
    StrideStylePayService strideStylePayService;

    @PostMapping(value = "/find-all")
    public ResponseEntity<?> getProductList(
            @RequestBody StrideStylePayRequest strideStylePayRequest) {
        return ResponseEntity.ok(strideStylePayService.findAllStryStylePay(strideStylePayRequest));
    }
}
