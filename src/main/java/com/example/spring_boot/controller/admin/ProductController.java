package com.example.spring_boot.controller.admin;

import com.example.spring_boot.entity.ProductEntity;
import com.example.spring_boot.payload.request.OderDetailRequest;
import com.example.spring_boot.payload.request.ProductRequest;
import com.example.spring_boot.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)

@RequestMapping("/product/manager")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping(value = "/find-all")
    public ResponseEntity<?> getProductList(ProductRequest productRequest) {
        return new ResponseEntity(productService.findAll(productRequest), HttpStatus.OK);
    }
    @GetMapping("/find-by-id/{id}")
    public ResponseEntity<?> getProductById(@PathVariable Long id) {
        Optional<ProductEntity> productRequest = productService.findByID(id);

        if (productRequest.isPresent()) {
            return new ResponseEntity(productRequest.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity("Category not found for ID: " + id, HttpStatus.NOT_FOUND);
        }
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
