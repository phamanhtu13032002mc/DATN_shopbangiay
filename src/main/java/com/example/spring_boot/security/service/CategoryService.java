package com.example.spring_boot.security.service;

import com.example.spring_boot.entity.Category;
import com.example.spring_boot.entity.User;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    List<Category> findAllDeleteIsFalse();
    List<Category> findAll();

    Category save(Category category);

    void delete(Long id);

    Optional<Category> findByID(Long id);

}
