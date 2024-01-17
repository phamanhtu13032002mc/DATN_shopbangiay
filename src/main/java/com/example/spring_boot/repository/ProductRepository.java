package com.example.spring_boot.repository;

import com.example.spring_boot.entity.ProductEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
    @Query("SELECT p " +
            "FROM ProductEntity p WHERE (:productId IS NULL OR p.id = :productId) " +
            "AND (:nameProduct IS NULL OR p.nameProduct LIKE CONCAT('%', :nameProduct, '%')) " +
            "AND (:nameCate IS NULL OR p.categoryEntity.name LIKE CONCAT('%', :nameCate, '%')) " +
            "AND (:minPrice IS NULL OR :maxPrice IS NULL OR (p.price BETWEEN :minPrice AND :maxPrice))"+

            "AND p.isDelete = false " +
            "GROUP BY p.id " +
            "ORDER BY p.date_create DESC")
    Page<Object[]> findAllProduct(
            @Param("productId") Long productId,
            @Param("nameProduct") String nameProduct,
            @Param("nameCate") String nameCate,
            @Param("minPrice") Double minPrice,
            @Param("maxPrice") Double maxPrice
            , Pageable pageable);

    @Query("SELECT DISTINCT  p " +
            "FROM ProductEntity p " +
            "JOIN p.categoryEntity " +
            "JOIN p.productDetailEntities " +
            "WHERE p.isDelete = false AND p.id = :productId")
    List<ProductEntity> findProductById(@Param("productId") Long productId);


    @Query(value = "select p from ProductEntity p where p.nameProduct like :name")
    Optional<ProductEntity> findByNameProduct(@Param("name") String name);

    @Query(value = "SELECT * FROM product p WHERE p.id = ? ", nativeQuery = true)
    ProductEntity findByIdProduct(Long id);

    @Query(value = "SELECT * FROM product p WHERE p.name_product = ? ", nativeQuery = true)
    ProductEntity findByCorrectNameProduct(String name_product);


    @Query(value = "SELECT product.id AS product_id, category.id AS category_id, product_detail.id AS product_detail_id, " +
            "product.name_product, category.name AS category_name " +
            "FROM product " +
            "JOIN category ON product.id_category = category.id " +
            "JOIN product_detail ON product.id = product_detail.id_product " +
            "WHERE product.is_delete = FALSE " +
            "AND product.name_product LIKE %:productName% " +
            "GROUP BY product_detail.id ", nativeQuery = true)
    List<Object[]> findProductsByName(@Param("productName") String productName);

    @Query(value = "SELECT DISTINCT p.* " +
            "FROM product p " +
            "LEFT JOIN product_detail pd ON p.id = pd.id_product " +
            "LEFT JOIN category c ON p.id_category = c.id " +
            "LEFT JOIN property pr ON pr.id_property = pd.id_property " +
            "LEFT JOIN size s ON s.id = pd.id_size " +
            "WHERE (:productId IS NULL OR p.id = :productId) " +
            "AND (:nameProduct IS NULL OR p.name_product like CONCAT('%', :nameProduct, '%')) " +
            "AND (:nameCate IS NULL OR c.name like CONCAT('%', :nameCate, '%')) " +
            "AND (:propertiesId IS NULL OR pr.id_property = :propertiesId)" +
            "AND (:sizeID IS NULL OR s.id = :sizeID) " +
            "AND (:minPrice IS NULL OR :maxPrice IS NULL OR (p.price BETWEEN :minPrice AND :maxPrice)) " +
            "AND p.is_delete = 0 " +
            "ORDER BY p.id DESC ",
            countQuery = "SELECT COUNT(DISTINCT p.id) " +
                    "FROM product p " +
                    "LEFT JOIN product_detail pd ON p.id = pd.id_product " +
                    "LEFT JOIN category c ON p.id_category = c.id " +
                    "LEFT JOIN property pr ON pr.id_property = pd.id_property " +
                    "LEFT JOIN size s ON s.id = pd.id_size " +
                    "WHERE (:productId IS NULL OR p.id = :productId)" +
                    " AND (:nameProduct IS NULL OR p.name_product like CONCAT('%', :nameProduct, '%'))" +
                    " AND (:nameCate IS NULL OR c.name like CONCAT('%', :nameCate, '%'))" +
                    " AND (:propertiesId IS NULL OR pr.id_property = :propertiesId)" +
                    " AND (:sizeID IS NULL OR s.id = :sizeID) " +
                    " AND (:minPrice IS NULL OR :maxPrice IS NULL OR (p.price BETWEEN :minPrice AND :maxPrice)) " +
                    "  AND p.is_delete = 0 ",
            nativeQuery = true)
    Page<ProductEntity> findProductsAndDetails(
            @Param("productId") Long productId,
            @Param("nameProduct") String nameProduct,
            @Param("nameCate") String nameCate,
            @Param("propertiesId") Long propertiesId,
            @Param("sizeID") Long sizeID,
            @Param("minPrice") Double minPrice,
            @Param("maxPrice") Double maxPrice,
             Pageable pageable

    );




}
