package com.example.spring_boot.repository;

import com.example.spring_boot.entity.ProductEntity;
import com.example.spring_boot.payload.request.ProductRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<ProductEntity,Long> {
    @Query(value = "SELECT * FROM product WHERE is_delete = 1 ORDER BY id DESC",nativeQuery = true)
    Page<ProductEntity> findAllProduct(ProductRequest productRequest, Pageable pageable);


    @Query(value = "select p from ProductEntity p where p.nameProduct like :name")
    Optional<ProductEntity> findByNameProduct(@Param("name") String name);

    @Query(value = "SELECT * FROM product p WHERE p.id = 1 ",nativeQuery = true)
    ProductEntity findByIdProduct(Long id);


}
