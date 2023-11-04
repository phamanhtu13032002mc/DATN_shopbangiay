package com.example.spring_boot.service;

import com.example.spring_boot.entity.CategoryEntity;
import com.example.spring_boot.payload.request.CategoryRequest;
import com.example.spring_boot.payload.response.CategoryResponse;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

    CategoryEntity save(CategoryEntity categoryEntity);

    void delete(Long id);

    Optional<CategoryEntity> findByID(Long id);

    Page<CategoryEntity> findAllCategory(CategoryRequest categoryRequest);



    List<CategoryResponse> findIdAndNameCategory();

    Object create(CategoryRequest categoryRequest);

    Object detele(CategoryRequest categoryRequest);

    Object update(CategoryRequest categoryRequest);
}
