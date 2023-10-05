package com.example.spring_boot.controller.admin;

import com.example.spring_boot.entity.Category;
import com.example.spring_boot.entity.Productdetail;
import com.example.spring_boot.payload.request.CreateProductDetail;
import com.example.spring_boot.security.service.ProducDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)

@RequestMapping("ProductDetailManager")
public class ProducDetailController {
    @Autowired
    ProducDetailService producDetailService;

    @GetMapping(value = "/findAllByIsDeleteFalse")
    public ResponseEntity<?> getCategoryList() {
        return new ResponseEntity(producDetailService.findAllByIsDeleteFalse(), HttpStatus.OK);
    }


    @GetMapping(value = "ProductDetailDelete/{id}")
    public ResponseEntity<?> DeleteProductDetail(@PathVariable("id") long id) {
        producDetailService.delete(id);
        return new ResponseEntity("successfully", HttpStatus.OK);
    }

    @PostMapping(value = "ProductDetailUpdateOrSave")
    public ResponseEntity<?> UpdateCategory(@RequestBody CreateProductDetail createProductDetail) {
        return new ResponseEntity(producDetailService.create(createProductDetail), HttpStatus.OK);
    }


}
