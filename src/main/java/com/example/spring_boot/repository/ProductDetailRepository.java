package com.example.spring_boot.repository;

import com.example.spring_boot.entity.ProductDetailEntity;
import com.example.spring_boot.entity.ProductEntity;
import com.example.spring_boot.payload.request.ProductDetailRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ProductDetailRepository extends JpaRepository<ProductDetailEntity,Long> {
    @Query(value ="SELECT * FROM product_detail WHERE idsize = ? AND idproperty = ? AND idProduct = ?",nativeQuery = true)
    Optional<ProductDetailEntity> CheckPrd(Long idsize, long idproperty, Long idProduct);
    @Query(value = "SELECT * FROM product_detail WHERE is_delete = 0 ORDER BY id DESC",nativeQuery = true)
    Page<ProductDetailEntity> findAllProductDetail(ProductDetailRequest productDetailRequest, Pageable pageable);

    @Query(value = "SELECT * FROM product_detail p WHERE p.id_product = ?",nativeQuery = true)
    ProductDetailEntity findByIdProduct(Long id);

    @Query(value = "SELECT * FROM product_detail p WHERE p.id = ?",nativeQuery = true)
    ProductDetailEntity findByIdProductDetail(Long id);}
