package com.example.spring_boot.repository;

import com.example.spring_boot.entity.ProductDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProductDetailRepository extends JpaRepository<ProductDetailEntity,Long> {
    @Query(value = "SELECT * FROM product_detail WHERE is_delete = 0 ORDER BY id DESC",nativeQuery = true)
    List<ProductDetailEntity> findAllByIsDeleteFase();
    @Query(value ="SELECT * FROM product_detail WHERE idsize = ? AND idproperty = ? AND idProduct = ?",nativeQuery = true)
    Optional<ProductDetailEntity> CheckPrd(Long idsize, long idproperty, Long idProduct);







}
