package com.example.spring_boot.repository;

import com.example.spring_boot.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<ProductEntity,Long> {
    @Query(value = "SELECT * FROM product WHERE is_delete = 0 ORDER BY id DESC",nativeQuery = true)
    List<ProductEntity> findAllByIsDeleteFase();
}
