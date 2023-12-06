package com.example.spring_boot.repository;

import com.example.spring_boot.entity.ProductEntity;
import com.example.spring_boot.payload.request.ProductDetailRequest;
import com.example.spring_boot.payload.request.ProductRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity,Long> {
    @Query("SELECT p " +
            "FROM ProductEntity p " +
            "WHERE (:productId IS NULL OR p.id = :productId) " +
            "AND (:nameProduct IS NULL OR p.nameProduct LIKE CONCAT('%', :nameProduct, '%')) " +
            "AND (:nameCate IS NULL OR p.categoryEntity.name LIKE CONCAT('%', :nameCate, '%')) " +
            "AND p.isDelete = false")
    Page<Object[]> findAllProduct(
            @Param("productId") Long productId,
            @Param("nameProduct") String nameProduct,
            @Param("nameCate") String nameCate
            ,Pageable pageable);

    @Query("SELECT DISTINCT  p " +
            "FROM ProductEntity p " +
            "JOIN p.categoryEntity " +
            "JOIN p.productDetailEntities " +
            "WHERE p.isDelete = false AND p.id = :productId")
    List<ProductEntity> findProductById(@Param("productId") Long productId);


    @Query(value = "select p from ProductEntity p where p.nameProduct like :name")
    Optional<ProductEntity> findByNameProduct(@Param("name") String name);

    @Query(value = "SELECT * FROM product p WHERE p.id = ? ",nativeQuery = true)
    ProductEntity findByIdProduct(Long id);


    @Query(value = "SELECT product.id AS product_id, category.id AS category_id, product_detail.id AS product_detail_id, " +
            "product.name_product, category.name AS category_name " +
            "FROM product " +
            "JOIN category ON product.id_category = category.id " +
            "JOIN product_detail ON product.id = product_detail.id_product " +
            "WHERE product.is_delete = FALSE " +
            "AND product.name_product LIKE %:productName% " +
            "GROUP BY product_detail.id ", nativeQuery = true)
    List<Object[]> findProductsByName(@Param("productName") String productName);

}
