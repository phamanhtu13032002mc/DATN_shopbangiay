package com.example.spring_boot.security.service.impl;

import com.example.spring_boot.entity.Category;
import com.example.spring_boot.repository.CategoryRepository;
import com.example.spring_boot.security.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryRepository categoryRepository;
    @Override
    public List<Category> findAllDeleteIsFalse() {
        return categoryRepository.findAllByIsDeleteFase();
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public void delete(Long id) {
        Category category  = categoryRepository.findById(id).get();
        category.setIsDelete(true);
        categoryRepository.save(category);
    }

    @Override
    public Optional<Category> findByID(Long id) {
        return categoryRepository.findById(id);
    }
}
