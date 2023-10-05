package com.example.spring_boot.repository;

import com.example.spring_boot.entity.Category;
import com.example.spring_boot.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {
    @Query(value = "SELECT * FROM product WHERE is_delete = 0 ORDER BY id DESC",nativeQuery = true)
    List<Product> findAllByIsDeleteFase();
}
