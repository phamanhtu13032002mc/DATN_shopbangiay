package com.example.spring_boot.repository;

import com.example.spring_boot.entity.CategoryEntity;
import com.example.spring_boot.entity.PropertyEntity;
import com.example.spring_boot.payload.request.PropertiesRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PropertyRepository extends JpaRepository<PropertyEntity,Long> {

    @Query("SELECT p  FROM PropertyEntity p " +
            "WHERE (:name IS NULL OR p.name LIKE CONCAT('%', :name, '%'))" +
            "AND p.isDelete = false ORDER BY p.idProperty DESC")
    Page<PropertyEntity> findAllProperties(@Param("name") String name, Pageable pageable);

    PropertyEntity findByIdProperty(Long idProperty);


    @Query("SELECT P FROM PropertyEntity P WHERE  P.name LIKE %:name%")
    Page<PropertyEntity> findByNameLike(String name, Pageable pageable);

    boolean existsByName(String name);
}
