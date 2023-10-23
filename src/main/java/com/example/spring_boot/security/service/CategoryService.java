package com.example.spring_boot.security.service;

import com.example.spring_boot.entity.CategoryEntity;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    List<CategoryEntity> findAllDeleteIsFalse();
    List<CategoryEntity> findAll();

    CategoryEntity save(CategoryEntity categoryEntity);

    void delete(Long id);

    Optional<CategoryEntity> findByID(Long id);

}
