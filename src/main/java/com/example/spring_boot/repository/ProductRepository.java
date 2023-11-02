package com.example.spring_boot.repository;

import com.example.spring_boot.entity.ProductEntity;
import com.example.spring_boot.payload.request.ProductDetailRequest;
import com.example.spring_boot.payload.request.ProductRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Objects;

public interface ProductRepository extends JpaRepository<ProductEntity,Long> {
    @Query("SELECT p " +
            "FROM ProductEntity p " +
            "JOIN p.productDetailEntities " +
            "JOIN CategoryEntity c ON p.id = c.id " +
            "WHERE p.isDelete = true " +
            "group by p.id ")
    Page<Object[]> findAllProduct(ProductRequest productRequest, Pageable pageable);

    @Query("SELECT p " +
            "FROM ProductEntity p " +
            "JOIN p.productDetailEntities " +
            "JOIN CategoryEntity c ON p.id = c.id " +
            "WHERE p.isDelete = true AND p.id = :productId")
    List<Object[]> findProductById(@Param("productId") Long productId);


}
