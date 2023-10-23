package com.example.spring_boot.controller.admin;

import com.example.spring_boot.entity.CategoryEntity;
import com.example.spring_boot.security.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)

@RequestMapping("/category-manager")
public class CategoryController {
    @Autowired
    CategoryService categoryService;
    @GetMapping(value = "/find-all")
    public ResponseEntity<?> getCategoryList() {
        return new  ResponseEntity(categoryService.findAllDeleteIsFalse(), HttpStatus.OK);
    }
    @GetMapping(value = "/get-by-id/{id}")
    public ResponseEntity<?> getCategoryById(@PathVariable("id") long id) {
        return new  ResponseEntity(categoryService.findByID(id), HttpStatus.OK);
    }
    @PostMapping(value = "/delete/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable("id") long id) {
        categoryService.delete(id);
        return new  ResponseEntity("successfully", HttpStatus.OK);
    }

    @PostMapping(value = "/update")
    public ResponseEntity<?> updateCategory(@RequestBody CategoryEntity categoryEntity) {
        return new  ResponseEntity(categoryService.save(categoryEntity), HttpStatus.OK);
    }

    @PostMapping(value = "/save")
    public ResponseEntity<?> saveCategory(@RequestBody CategoryEntity categoryEntity) {
        return new  ResponseEntity(categoryService.save(categoryEntity), HttpStatus.OK);
    }
}
