package com.example.spring_boot.controller.admin;

import com.example.spring_boot.entity.Product;
import com.example.spring_boot.entity.User;
import com.example.spring_boot.security.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)

@RequestMapping("ProductManager")
public class ProducConrtroller {
    @Autowired
    ProductService productService;

    @GetMapping(value = "/findAllByIsDeleteFalse")
    public ResponseEntity<?> getUserList() {
        return new  ResponseEntity(productService.findAllByIsDeleteFalse(), HttpStatus.OK);
    }
    @GetMapping(value = "Product/{id}")
    public ResponseEntity<?> getUserById(@PathVariable("id") long id) {

        return new  ResponseEntity(productService.findById(id), HttpStatus.OK);
    }
    @GetMapping(value = "ProductDelete/{id}")
    public ResponseEntity<?> DeleteAccount(@PathVariable("id") long id) {
        productService.delete(id);
        return new  ResponseEntity("ok", HttpStatus.OK);
    }

    @PostMapping(value = "ProductUpdateOrSave")
    public ResponseEntity<?> UpdateAccount(@RequestBody Product product) {
        return new  ResponseEntity(productService.create(product), HttpStatus.OK);
    }
}
