package com.example.spring_boot.controller.admin;

import com.example.spring_boot.payload.request.ProductDetailRequest;
import com.example.spring_boot.service.ProductDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)

@RequestMapping("/product-detail-manager")
public class ProductDetailController {
    @Autowired
    ProductDetailService productDetailService;

    @PostMapping(value = "/find-all")
    public ResponseEntity<?> getProductList(
            @RequestBody ProductDetailRequest productDetailRequest) {
        return ResponseEntity.ok(productDetailService.findAllProductDetail(productDetailRequest));
    }





}
