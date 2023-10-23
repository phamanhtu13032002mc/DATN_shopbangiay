package com.example.spring_boot.repository;

import com.example.spring_boot.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<CategoryEntity,Long> {
    @Query(value = "SELECT * FROM category WHERE is_delete = 0 ORDER BY id DESC",nativeQuery = true)
    List<CategoryEntity> findAllByIsDeleteFase();


    Optional<CategoryEntity> findByName(String name);
}
