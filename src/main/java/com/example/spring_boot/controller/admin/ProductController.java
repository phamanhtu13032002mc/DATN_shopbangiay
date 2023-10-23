package com.example.spring_boot.controller.admin;

import com.example.spring_boot.entity.ProductEntity;
import com.example.spring_boot.security.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)

@RequestMapping("/product/manager")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping(value = "/findAllByIsDeleteFalse")
    public ResponseEntity<?> getUserList() {
        return new  ResponseEntity(productService.findAllByIsDeleteFalse(), HttpStatus.OK);
    }
    @GetMapping(value = "/product/{id}")
    public ResponseEntity<?> getUserById(@PathVariable("id") long id) {

        return new  ResponseEntity(productService.findById(id), HttpStatus.OK);
    }
    @PostMapping(value = "/delete/{id}")
    public ResponseEntity<?> deleteAccount(@PathVariable("id") long id) {
        productService.delete(id);
        return new  ResponseEntity("ok", HttpStatus.OK);
    }

    @PostMapping(value = "/update-or-save")
    public ResponseEntity<?> updateAccount(@RequestBody ProductEntity productEntity) {
        return new  ResponseEntity(productService.create(productEntity), HttpStatus.OK);
    }
}
