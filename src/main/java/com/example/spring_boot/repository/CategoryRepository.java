package com.example.spring_boot.repository;

import com.example.spring_boot.entity.CategoryEntity;
import com.example.spring_boot.payload.request.CategoryRequest;
import com.example.spring_boot.payload.response.CategoryResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<CategoryEntity,Long> {

    @Query(value = "SELECT * FROM category WHERE is_delete = 0 ORDER BY id DESC",nativeQuery = true)
    Page<CategoryEntity> findAllCategory(CategoryRequest categoryRequest, Pageable pageable);
    @Query(value = "select c.id as id ,c.name as nameCategory from CategoryEntity c")
    List<CategoryResponse> findNameCategory();

    @Query(value = "select c from CategoryEntity c where c.id =?1 ")
    List<CategoryEntity> findByCategoryID(Long id);



}
