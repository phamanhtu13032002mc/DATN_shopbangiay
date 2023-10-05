package com.example.spring_boot.controller.admin;

import com.example.spring_boot.entity.Category;
import com.example.spring_boot.entity.User;
import com.example.spring_boot.security.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)

@RequestMapping("/CategoryManager")
public class CategoryController {
    @Autowired
    CategoryService categoryService;
    @GetMapping(value = "/findAllByIsDeleteFalse")
    public ResponseEntity<?> getCategoryList() {
        return new  ResponseEntity(categoryService.findAllDeleteIsFalse(), HttpStatus.OK);
    }
    @GetMapping(value = "Category/{id}")
    public ResponseEntity<?> getCategoryById(@PathVariable("id") long id) {

        return new  ResponseEntity(categoryService.findByID(id), HttpStatus.OK);
    }
    @GetMapping(value = "CategoryDelete/{id}")
    public ResponseEntity<?> DeleteCategory(@PathVariable("id") long id) {
        categoryService.delete(id);
        return new  ResponseEntity("successfully", HttpStatus.OK);
    }

    @PostMapping(value = "CategoryUpdate")
    public ResponseEntity<?> UpdateCategory(@RequestBody Category category) {
        return new  ResponseEntity(categoryService.save(category), HttpStatus.OK);
    }

    @PostMapping(value = "CategorySave")
    public ResponseEntity<?> SaveCategory(@RequestBody Category category) {
        return new  ResponseEntity(categoryService.save(category), HttpStatus.OK);
    }
}
