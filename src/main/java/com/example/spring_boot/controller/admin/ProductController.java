package com.example.spring_boot.controller.admin;

import com.example.spring_boot.entity.CategoryEntity;
import com.example.spring_boot.entity.ProductEntity;
import com.example.spring_boot.payload.DataObj;
import com.example.spring_boot.payload.request.CategoryRequest;
import com.example.spring_boot.payload.request.PageableRequest;
import com.example.spring_boot.payload.request.ProductRequest;
import com.example.spring_boot.repository.ProductDetailRepository;
import com.example.spring_boot.repository.ProductRepository;
import com.example.spring_boot.service.CategoryService;
import com.example.spring_boot.service.ProductService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/product/manager")
public class ProductController {
    @Autowired
    ProductService productService;
    @Autowired
    CategoryService categoryService;

    @Autowired
    ProductRepository productRepository;

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
    @GetMapping("/find-id-name-category")
    public ResponseEntity<?> findIdAndNameCategory() {
        return ResponseEntity.ok(categoryService.findIdAndNameCategory());
    }
    @PostMapping("/save")
    public ResponseEntity<?> save(@ModelAttribute ProductRequest productRequest) {

        return ResponseEntity.ok(productService.save(productRequest));

    }
    @PostMapping("/delete")
    public ResponseEntity<?> delete(@RequestBody ProductRequest productRequest) {

        return ResponseEntity.ok(productService.delete(productRequest));

    }

    @GetMapping("/find-by-name/{id}")
    public ResponseEntity<?> getProductByName(@PathVariable Long id) {

            return ResponseEntity.ok(productRepository.findByIdProduct(id));
    }


}
