package com.example.spring_boot.controller.admin;

import com.example.spring_boot.entity.CategoryEntity;
import com.example.spring_boot.entity.ProductEntity;
import com.example.spring_boot.payload.DataObj;
import com.example.spring_boot.payload.request.*;
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

    @GetMapping(value = "/find-by-id/{idProduct}")
    public ResponseEntity<?> findById(@PathVariable Long idProduct){
        return ResponseEntity.ok(productService.findByIdProduct(idProduct));
    }
    @GetMapping("/find-id-name-category")
    public ResponseEntity<?> findIdAndNameCategory() {
        return ResponseEntity.ok(categoryService.findIdAndNameCategory());
    }
    @PostMapping("/save")
    public ResponseEntity<?> save(@ModelAttribute CreateProduct createProduct) {

        return ResponseEntity.ok(productService.save(createProduct));

    }
    @PostMapping("/delete/{idProduct}")
    public ResponseEntity<?> delete(@PathVariable Long idProduct) {

        return ResponseEntity.ok(productService.delete(idProduct));

    }

    @GetMapping("/find-by-name/{id}")
    public ResponseEntity<?> getProductById(@PathVariable Long id) {

            return ResponseEntity.ok(productRepository.findByIdProduct(id));
    }

    @PostMapping("/find-by-name")
    public ResponseEntity<?> getProductByName(@RequestBody ProductRequest productRequest) {
        return ResponseEntity.ok(productRepository.findProductsByName(productRequest.getNameProduct()));
    }
   @PostMapping("/update-quantity-product")
    public ResponseEntity<?> UpdateQuantityProduct(@RequestBody UpdateQuantityProductRequest quantityProductRequest) {
        return ResponseEntity.ok(productService.updateQuantityProduct(quantityProductRequest));
    }

    @PostMapping("find-quantity-product")
    public ResponseEntity<?> findQuantityProduct(@RequestBody FindQuantityProductRequest findQuantityProductRequest){
        return ResponseEntity.ok(productService.findQuantityProduct(findQuantityProductRequest));
    }

}
