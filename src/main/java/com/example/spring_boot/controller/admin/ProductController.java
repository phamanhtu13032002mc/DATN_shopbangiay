package com.example.spring_boot.controller.admin;

import com.example.spring_boot.entity.ProductEntity;
import com.example.spring_boot.payload.request.PageableRequest;
import com.example.spring_boot.payload.request.ProductRequest;
import com.example.spring_boot.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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

    @PostMapping(value = "/find-all")
    public ResponseEntity<?> getProductList(
            @RequestBody ProductRequest productRequest) {
        return ResponseEntity.ok(productService.findAllProduct(productRequest));
    }

    @GetMapping("/find-by-id/{id}")
    public ResponseEntity<?> getProductById(@PathVariable Long id) {
        Optional<ProductEntity> productRequest = productService.findByID(id);

        if (productRequest.isPresent()) {
            return new ResponseEntity(productRequest.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity("Product not found for ID: " + id, HttpStatus.NOT_FOUND);
        }
    }

}
