package com.example.spring_boot.controller.admin;

import com.example.spring_boot.entity.CategoryEntity;
import com.example.spring_boot.entity.ProductEntity;
import com.example.spring_boot.payload.DataObj;
import com.example.spring_boot.payload.request.CategoryRequest;
import com.example.spring_boot.payload.request.PageableRequest;
import com.example.spring_boot.payload.request.ProductRequest;
import com.example.spring_boot.service.CategoryService;
import com.example.spring_boot.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/product/manager")
public class ProductController {
    @Autowired
    ProductService productService;
    @Autowired
    CategoryService categoryService;

    @PostMapping(value = "/find-all")
    public ResponseEntity<?> getProductList(
            @RequestBody ProductRequest productRequest) {
        return ResponseEntity.ok(productService.findAllProduct(productRequest));
    }

    @GetMapping(value = "/find-by-id/{idProduct}")
    public ResponseEntity<?> findById(@PathVariable Long idProduct){
        return ResponseEntity.ok(productService.findByIdProduct(idProduct));
    }
    @GetMapping("/find-id-name-category")
    public ResponseEntity<?> findIdAndNameCategory() {
        return ResponseEntity.ok(categoryService.findIdAndNameCategory());
    }

}
