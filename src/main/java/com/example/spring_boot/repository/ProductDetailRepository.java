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


    @Query(value = "SELECT * FROM product_detail p WHERE p.id_product = ?",nativeQuery = true)
    ProductDetailEntity findByIdProduct(Long id);

    @Query(value = "SELECT * FROM product_detail p WHERE p.id = ?",nativeQuery = true)
    ProductDetailEntity findByIdProductDetail(Long id);

    @Query(value = "SELECT * FROM product_detail pd WHERE pd.id_product = ? AND pd.id_property = ? AND pd.id_size = ? ",nativeQuery = true)
    ProductDetailEntity findByIdProductAndIdPropertyAndAndIdSize(Long idProduct,Long idProperty,Long idSize);

    @Query(value = "select u from ProductDetailEntity u where u.idProduct.id = :idProduct " +
            "and u.isDelete = false " )
    Page<Object> findProductDetailByProduct(@Param("idProduct") Long idProduct, Pageable pageable);


    @Query(value = "SELECT p from ProductDetailEntity p where " +
            "p.idProduct.id = :idProduct " +
            "and p.idProperty.idProperty= :idProperty " +
            "and p.idSize.id = :idSize")
    Object findQuantity(@Param("idProduct") Long idProduct, @Param("idProperty") Long idProperty, @Param("idSize") Long idSize);

}