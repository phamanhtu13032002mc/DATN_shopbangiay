package com.example.spring_boot.repository;

import com.example.spring_boot.entity.Category;
import com.example.spring_boot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category,Long> {
    @Query(value = "SELECT * FROM category WHERE is_delete = 0 ORDER BY id DESC",nativeQuery = true)
    List<Category> findAllByIsDeleteFase();


    Optional<Category> findByName(String name);
}
