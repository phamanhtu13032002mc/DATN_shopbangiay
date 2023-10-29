package com.example.spring_boot.controller.admin;

import com.example.spring_boot.payload.request.OderDetailRequest;
import com.example.spring_boot.payload.request.ProductDetailRequest;
import com.example.spring_boot.service.ProducDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)

@RequestMapping("/product-detail-manager")
public class ProducDetailController {
    @Autowired
    ProducDetailService producDetailService;

    @GetMapping(value = "/find-all")
    public ResponseEntity<?> getOderDetailList(ProductDetailRequest productDetailRequest) {
        return new ResponseEntity(producDetailService.findAll(productDetailRequest), HttpStatus.OK);
    }


    @PostMapping(value = "/delete/{id}")
    public ResponseEntity<?> deleteProductDetail(@PathVariable("id") long id) {
        producDetailService.delete(id);
        return new ResponseEntity("successfully", HttpStatus.OK);
    }



}
