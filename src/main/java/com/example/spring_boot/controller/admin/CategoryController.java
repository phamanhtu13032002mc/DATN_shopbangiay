package com.example.spring_boot.controller.admin;

import com.example.spring_boot.entity.CategoryEntity;
import com.example.spring_boot.payload.request.CategoryRequest;
import com.example.spring_boot.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)

@RequestMapping("/category-manager")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @GetMapping(value = "/find-all")
    public ResponseEntity<?> getCategoryList(CategoryRequest categoryRequest) {
        return new ResponseEntity(categoryService.findAll(categoryRequest), HttpStatus.OK);
    }
    @GetMapping("/find-by-id/{id}")
    public ResponseEntity<?> getCategoryById(@PathVariable Long id) {
        Optional<CategoryEntity> categoryRequest = categoryService.findByID(id);

        if (categoryRequest.isPresent()) {
            return new ResponseEntity(categoryRequest.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity("Category not found for ID: " + id, HttpStatus.NOT_FOUND);
        }
    }

}
