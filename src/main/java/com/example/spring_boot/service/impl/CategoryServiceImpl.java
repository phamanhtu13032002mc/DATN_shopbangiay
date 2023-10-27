package com.example.spring_boot.service.impl;

import com.example.spring_boot.entity.CategoryEntity;
import com.example.spring_boot.payload.request.CategoryRequest;
import com.example.spring_boot.repository.CategoryRepository;
import com.example.spring_boot.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryRepository categoryRepository;
    @Override
    public List<CategoryEntity> findAllDeleteIsFalse() {
        return categoryRepository.findAllByIsDeleteFase();
    }

    @Override
    public List<CategoryEntity> findAll(CategoryRequest categoryRequest) {

        return categoryRepository.findAll();
    }

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

}
