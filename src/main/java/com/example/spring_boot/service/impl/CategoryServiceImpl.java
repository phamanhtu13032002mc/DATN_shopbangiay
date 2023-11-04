package com.example.spring_boot.service.impl;

import com.example.spring_boot.entity.CategoryEntity;
import com.example.spring_boot.payload.request.CategoryRequest;
import com.example.spring_boot.payload.response.CategoryResponse;
import com.example.spring_boot.repository.CategoryRepository;
import com.example.spring_boot.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public CategoryEntity save(CategoryEntity categoryEntity) {
        return categoryRepository.save(categoryEntity);
    }

    @Override
    public void delete(Long id) {
        CategoryEntity categoryEntity = categoryRepository.findById(id).get();
        categoryEntity.setIsDelete(true);
        categoryRepository.save(categoryEntity);
    }

    @Override
    public Optional<CategoryEntity> findByID(Long id) {
        return categoryRepository.findById(id);
    }

    @Override
    public Page<CategoryEntity> findAllCategory(CategoryRequest categoryRequest) {
        Pageable pageable = PageRequest.of(Math.toIntExact(categoryRequest.getPage()), Math.toIntExact(categoryRequest.getSize()));
        return categoryRepository.findAllCategory(categoryRequest, pageable);
    }

    @Override
    public List<CategoryResponse> findIdAndNameCategory() {
        return categoryRepository.findNameCategory();
    }


}
