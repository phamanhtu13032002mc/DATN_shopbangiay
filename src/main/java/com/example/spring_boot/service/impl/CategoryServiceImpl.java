package com.example.spring_boot.service.impl;

import com.example.spring_boot.entity.CategoryEntity;
import com.example.spring_boot.entity.EventEntity;
import com.example.spring_boot.payload.DataObj;
import com.example.spring_boot.payload.request.CategoryRequest;
import com.example.spring_boot.payload.response.CategoryResponse;
import com.example.spring_boot.repository.CategoryRepository;
import com.example.spring_boot.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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

    @Override
    public Object create(CategoryRequest categoryRequest) {
        try {
            if (categoryRequest.getName() == null){
                return new DataObj().setEdesc("Name event not null !!!");
            }
            if (categoryRequest.getGender() == null){
                return new DataObj().setEdesc("Gender not null !!!");
            }
            else {
                CategoryEntity category = new CategoryEntity();
                category.setName(categoryRequest.getName());
                category.setGender(categoryRequest.getGender());
                return new DataObj().setEcode("200").setEdesc("Create Complete").setData(categoryRepository.save(category));

            }
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Lỗi Category");
        }
    }

    @Override
    public Object detele(CategoryRequest categoryRequest) {
        try {
            Optional<CategoryEntity> categoryOptional = categoryRepository.findById(categoryRequest.getId());
            if (categoryOptional.isEmpty()) {
                return new DataObj().setEcode("505").setEdesc("ID does not exit !");
            } else {
                CategoryEntity category = categoryOptional.get();
                category.setIsDelete(true);
                return new DataObj().setEcode("200").setEdesc("DELETE Complete").setData(categoryRepository.save(category));
            }
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Lỗi xóa");
        }
    }

    @Override
    public Object update(CategoryRequest categoryRequest) {
        try {
            Optional<CategoryEntity> optionalCategory = categoryRepository.findById(categoryRequest.getId());
            if (optionalCategory.isPresent()) {
                CategoryEntity category = optionalCategory.get();
                category.setName(categoryRequest.getName());
                category.setGender(categoryRequest.getGender());
                return new DataObj().setEcode("200").setEdesc("Success").setData(categoryRepository.save(category));
            } else {
                return new DataObj().setEcode("505").setEdesc("ID does not exit !");
            }
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Lỗi update");
        }
    }

    @Override
    public DataObj findByNameLike(CategoryRequest categoryRequest) {
        Pageable pageable = PageRequest.of(Math.toIntExact(categoryRequest.getPage()), Math.toIntExact(categoryRequest.getSize()));
        Page<CategoryEntity> categoryPage = categoryRepository.findByNameLike(categoryRequest.getName(), pageable);

        DataObj dataObj = new DataObj();
        dataObj.setEcode("200");
        dataObj.setEdesc("success");
        dataObj.setData(categoryPage.getContent());

        return dataObj;
    }



}
