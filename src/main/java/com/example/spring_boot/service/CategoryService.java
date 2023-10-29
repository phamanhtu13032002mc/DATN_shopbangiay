package com.example.spring_boot.service;

import com.example.spring_boot.entity.CategoryEntity;
import com.example.spring_boot.payload.request.CategoryRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    List<CategoryEntity> findAllDeleteIsFalse();

    CategoryEntity save(CategoryEntity categoryEntity);

    void delete(Long id);

    Optional<CategoryEntity> findByID(Long id);

    Page<CategoryEntity> findAll(CategoryRequest categoryRequest, PageRequest pageRequest);
}
